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
import actions from '../../../redux/empresa/actions';

class AdminEmpresa extends Component {
  columns = [
    {
      title: 'CNPJ',
      dataIndex: 'cnpj',
      key: 'cnpj',
      render: (text, record) => (
        <Link to={`/dashboard/admin-empresa/empresa/${record.id}`}>{text}</Link>
      ),
    },
    {
      title: 'Razão Social',
      dataIndex: 'razaoSocial',
      key: 'razaoSocial',
      defaultSortOrder: 'ascend',
      sorter: (a, b) => (a.razaoSocial === b.razaoSocial ? 0 : a.razaoSocial > b.razaoSocial ? 1 : -1),
    },
    {
      title: 'Nome Fantasia',
      dataIndex: 'nomeFantasia',
      key: 'nomeFantasia',
      sorter: (a, b) => (a.nomeFantasia === b.nomeFantasia ? 0 : a.nomeFantasia > b.nomeFantasia ? 1 : -1),
    },
    {
      title: 'Ativo?',
      dataIndex: 'ativo',
      key: 'ativo',
      render: (text, record) => (record.ativo ? 'Ativo' : 'Inativo'),
      sorter: (a, b) => a.ativo > b.ativo,
    },
  ];

  componentWillMount() {
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
    return (
      <LayoutContent>
        <PageHeader>
          Empresas &nbsp;&nbsp;
          {this.props.loading ? <Spin /> : ''}
        </PageHeader>
        {this.renderAlert()}
        <Link to="/dashboard/admin-empresa/new">
          <Button type="primary">Novo</Button>
        </Link>
        <br />
        <br />
        <Box>
          <Table pagination={false} columns={this.columns} dataSource={this.props.empresas} />
        </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Empresa.resposta,
  tipoResposta: state.Empresa.tipoResposta,
  empresas: state.Empresa.all,
  loading: state.Empresa.loading,
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
)(AdminEmpresa);
