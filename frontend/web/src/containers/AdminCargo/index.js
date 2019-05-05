import React, { Component } from 'react';
import { connect, } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link } from "react-router-dom";
import { Table, Button, Alert, Spin } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import actions from '../../redux/cargo/actions';

class AdminCargo extends Component {

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
          <br/>
        </div>
      );
    } 
  }

  render() {

    const columns = [
      {
        title: 'Número', dataIndex: 'numero', key: 'numero',
        render: (text, record) => <Link to={`/dashboard/admin-cargo/cargo/${record.id}`}>{text}</Link>,
        sorter: (a, b) => a.numero - b.numero,
      },
      {
        title: 'Descrição', dataIndex: 'descricao', key: 'descricao',
        sorter: (a, b) => a.descricao === b.descricao ? 0 : a.descricao > b.descricao ? 1 : -1,
      },
      { title: 'Ativo?', dataIndex: 'ativo', key: 'ativo',
        render: (text, record) => record.ativo ? 'Ativo' : 'Inativo',
        sorter: (a, b) => a.ativo > b.ativo,
      },
    ];

    return (
      <LayoutContent>
        <PageHeader>Cargos &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Link to={`/dashboard/admin-cargo/new`}>
            <Button type="primary">
              Novo
            </Button>
          </Link>
          <br/><br/>
          <Box>
            <Table
              pagination={false}
              columns={columns}
              dataSource={this.props.cargos}
            />
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Cargo.resposta,
  tipoResposta: state.Cargo.tipoResposta,
  cargos: state.Cargo.all,
  loading: state.Cargo.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  { 
    fetchAll: actions.fetchAll,
    clearResposta: actions.clearResposta,
  }, dispatch
);

export default connect(mapStateToProps, mapDispatchToProps)(AdminCargo);