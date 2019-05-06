import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link } from 'react-router-dom';
import { Field, reduxForm } from 'redux-form';
import {
  Button, Row, Col, Spin, Alert,
} from 'antd';
import { TextField, SwitchField } from 'redux-form-antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import ContentHolder from '../../components/utility/contentHolder';
import actions from '../../../redux/filial/actions';
import actionsEmpresa from '../../../redux/empresa/actions';

class AdminFilialNew extends Component {
  componentDidMount() {
    this.props.fetchAllEmpresas();
  }

  renderAlert() {
    if (this.props.tipoResposta && this.props.tipoResposta !== 'success') {
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
    if (this.props.tipoResposta === 'success') {
      this.props.history.push('/dashboard/admin-filial');
    }

    const colStyle = {
      marginBottom: '16px',
    };
    const {
      handleSubmit, submitting, pristine, reset,
    } = this.props;
    const options = this.props.empresas
      ? this.props.empresas
        .filter(empresa => empresa.ativo)
        .map(empresa => (
          <option value={empresa.id}>{`${empresa.cnpj} - ${empresa.razaoSocial}`}</option>
        ))
      : '';

    return (
      <LayoutContent>
        <PageHeader>
          Filial &nbsp;&nbsp;
          {this.props.loading ? <Spin /> : ''}
        </PageHeader>
        {this.renderAlert()}
        <Box title="Cadastro">
          <ContentHolder>
            <form onSubmit={handleSubmit(this.props.save)}>
              <Row gutter={16}>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Empresa</b>
                  <br />
                  <Field name="empresa" component="select">
                    <option value="">Selecione</option>
                    {options}
                  </Field>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Razão Social</b>
                  <Field name="razaoSocial" component={TextField} />
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Nome Fantasia</b>
                  <Field name="nomeFantasia" component={TextField} />
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>CNPJ</b>
                  <Field name="cnpj" component={TextField} />
                </Col>
                <Col md={6} sm={12} xs={24} style={colStyle}>
                  <br />
                  <Field
                    name="ativo"
                    component={SwitchField}
                    checkedChildren="Ativo"
                    unCheckedChildren="Inativo"
                  />
                </Col>
              </Row>
              <Button type="primary" htmlType="submit" disabled={submitting || this.props.loading}>
                Salvar
              </Button>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <Link to="/dashboard/admin-filial/">
                <Button type="danger">Cancelar</Button>
              </Link>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <Button
                type="secondary"
                disabled={pristine || submitting || this.props.loading}
                onClick={reset}
              >
                Limpar
              </Button>
            </form>
          </ContentHolder>
        </Box>
      </LayoutContent>
    );
  }
}

const validate = (values) => {
  const errors = {};

  if (!values.empresa) {
    errors.empresa = 'Selecione a Empresa';
  }
  if (!values.razaoSocial) {
    errors.razaoSocial = 'Informe a Razão Social';
  }
  if (!values.nomeFantasia) {
    errors.nomeFantasia = 'Informe o Nome Fantasia';
  }
  if (!values.cnpj) {
    errors.cnpj = 'Informe o CNPJ';
  } else if (isNaN(Number(values.cnpj))) {
    errors.cnpj = 'Apenas números para o CNPJ';
  } else if (values.cnpj.length > 14 || values.cnpj.length < 14) {
    errors.cnpj = 'CNPJ deve ter 14 dígitos';
  }

  return errors;
};

const mapStateToProps = state => ({
  resposta: state.Filial.resposta,
  tipoResposta: state.Filial.tipoResposta,
  loading: state.Filial.loading,
  empresas: state.Empresa.all,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    save: actions.save,
    clearResposta: actions.clearResposta,
    fetchAllEmpresas: actionsEmpresa.fetchAll,
  },
  dispatch,
);

AdminFilialNew = reduxForm({
  form: 'AdminFilialForm',
  validate,
})(AdminFilialNew);

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(AdminFilialNew);
