import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link } from 'react-router-dom';
import {
  Table, Button, Alert, Spin,
} from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import actions from '../../../redux/usuario/actions';

class AdminUsuario extends Component {
  componentDidMount() {
    this.props.fetchAll();
  }

  componentWillUnmount() {
    this.props.clearResposta();
  }

  renderAlert() {
    if (this.props.resposta) {
      return (
        <div>
          <Alert
            message={this.props.resposta}
            type={this.props.tipoResposta}
            closable
            afterClose={this.props.clearResposta}
          />
          <br />
        </div>
      );
    }
  }

  render() {
    const columns = [
      {
        title: 'Nome',
        dataIndex: 'name',
        key: 'name',
        render: (text, record) => (
          <Link to={`/dashboard/admin-usuario/usuario/${record.id}`}>{text}</Link>
        ),
        sorter: (a, b) => (a.name === b.name ? 0 : a.name > b.name ? 1 : -1),
      },
      {
        title: 'Usuário',
        dataIndex: 'username',
        key: 'username',
        sorter: (a, b) => (a.username === b.username ? 0 : a.username > b.username ? 1 : -1),
      },
      {
        title: 'Ativo?',
        dataIndex: 'ativo',
        key: 'ativo',
        render: (text, record) => (record.ativo ? 'Ativo' : 'Inativo'),
        sorter: (a, b) => a.ativo > b.ativo,
      },
    ];

    return (
      <LayoutContent>
        <PageHeader>
Usuários &nbsp;&nbsp;
          {this.props.loading ? <Spin /> : ''}
        </PageHeader>
        {this.renderAlert()}
        <Link to="/dashboard/admin-usuario/new">
          <Button type="primary">Novo</Button>
        </Link>
        <br />
        <br />
        <Box>
          <Table pagination={false} columns={columns} dataSource={this.props.usuarios} />
        </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Usuario.resposta,
  tipoResposta: state.Usuario.tipoResposta,
  usuarios: state.Usuario.all,
  loading: state.Usuario.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    fetchAll: actions.fetchAll,
    clearResposta: actions.clearResposta,
  },
  dispatch,
);

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(AdminUsuario);
