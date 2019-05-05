import React, { Component } from 'react';
import { connect, } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link } from "react-router-dom";
import { Table, Button, Alert, Spin } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import actions from '../../redux/fazenda/actions';

class AdminFazenda extends Component {

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
        render: (text, record) => <Link to={`/dashboard/admin-fazenda/fazenda/${record.id}`}>{text}</Link>,
        sorter: (a, b) => a.numero - b.numero,
        defaultSortOrder: 'ascend',
      },
      {
        title: 'Nome', dataIndex: 'nome', key: 'nome',
        render: (text, record) => <Link to={`/dashboard/admin-fazenda/fazenda/${record.id}`}>{text}</Link>,
        sorter: (a, b) => a.nome === b.nome ? 0 : a.nome > b.nome ? 1 : -1,
      },
      {
        title: 'Empresa', dataIndex: 'empresa', key: 'empresa',
        render: (text, record) => record.filial.empresa ? record.filial.empresa.razaoSocial : '',
        sorter: (a, b) => a.razaoSocial === b.razaoSocial ? 0 : a.razaoSocial > b.razaoSocial ? 1 : -1,
      },
      {
        title: 'Filial', dataIndex: 'filial', key: 'filial',
        render: (text, record) => record.filial ? record.filial.razaoSocial : '',
        sorter: (a, b) => a.razaoSocial === b.razaoSocial ? 0 : a.razaoSocial > b.razaoSocial ? 1 : -1,
      },
      { title: 'Ativo?', dataIndex: 'ativo', key: 'ativo',
        render: (text, record) => record.ativo ? 'Ativo' : 'Inativo',
        sorter: (a, b) => a.ativo > b.ativo,
      },
    ];

    return (
      <LayoutContent>
        <PageHeader>Fazendas &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Link to={`/dashboard/admin-fazenda/new`}>
            <Button type="primary">
              Novo
            </Button>
          </Link>
          <br/><br/>
          <Box>
            <Table
              pagination={false}
              columns={columns}
              dataSource={this.props.fazendas}
            />
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Fazenda.resposta,
  tipoResposta: state.Fazenda.tipoResposta,
  fazendas: state.Fazenda.all,
  loading: state.Fazenda.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  { 
    fetchAll: actions.fetchAll,
    clearResposta: actions.clearResposta,
  }, dispatch
);

export default connect(mapStateToProps, mapDispatchToProps)(AdminFazenda);