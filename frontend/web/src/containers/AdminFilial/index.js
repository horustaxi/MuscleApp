import React, { Component } from 'react';
import { connect, } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link } from "react-router-dom";
import { Table, Button, Alert, Spin } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import actions from '../../redux/filial/actions';

class AdminFilial extends Component {

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
        title: 'Empresa', dataIndex: 'empresa', key: 'empresa',
        render: (text, record) => record.empresa ? record.empresa.razaoSocial : '',
        sorter: (a, b) => a.razaoSocial === b.razaoSocial ? 0 : a.razaoSocial > b.razaoSocial ? 1 : -1,
      },
      {
        title: 'CNPJ', dataIndex: 'cnpj', key: 'cnpj',
        render: (text, record) => <Link to={`/dashboard/admin-filial/filial/${record.id}`}>{text}</Link>,
      },
      {
        title: 'Razão Social', dataIndex: 'razaoSocial', key: 'razaoSocial',
        defaultSortOrder: 'ascend',
        sorter: (a, b) => a.razaoSocial === b.razaoSocial ? 0 : a.razaoSocial > b.razaoSocial ? 1 : -1,
      },
      {
        title: 'Nome Fantasia', dataIndex: 'nomeFantasia', key: 'nomeFantasia',
        sorter: (a, b) => a.nomeFantasia === b.nomeFantasia ? 0 : a.nomeFantasia > b.nomeFantasia ? 1 : -1,
      },
      { title: 'Ativo?', dataIndex: 'ativo', key: 'ativo',
        render: (text, record) => record.ativo ? 'Ativo' : 'Inativo',
        sorter: (a, b) => a.ativo > b.ativo,
      },
    ];

    return (
      <LayoutContent>
        <PageHeader>Filiais &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Link to={`/dashboard/admin-filial/new`}>
            <Button type="primary">
              Novo
            </Button>
          </Link>
          <br/><br/>
          <Box>
            <Table
              pagination={false}
              columns={columns}
              dataSource={this.props.filiais}
            />
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Filial.resposta,
  tipoResposta: state.Filial.tipoResposta,
  filiais: state.Filial.all,
  loading: state.Filial.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  { 
    fetchAll: actions.fetchAll,
    clearResposta: actions.clearResposta,
  }, dispatch
);

export default connect(mapStateToProps, mapDispatchToProps)(AdminFilial);