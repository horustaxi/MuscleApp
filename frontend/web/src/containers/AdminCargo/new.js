import React, { Component, } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { reduxForm, } from 'redux-form'
import { Spin, Alert } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import ContentHolder from '../../components/utility/contentHolder';
import actions from '../../redux/cargo/actions';
import { Form, validate } from './common';

class AdminCargoNew extends Component {

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
          <br/>
        </div>
      );
    } 
  }

  render() {

    if (this.props.tipoResposta === 'success') {
      this.props.history.push('/dashboard/admin-cargo');
    }

    const { handleSubmit, submitting, pristine, reset } = this.props;

    return (
      <LayoutContent>        
        <PageHeader>Cargo &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Box title="Cadastro">
          <ContentHolder>
            <Form
              onSubmit={handleSubmit(this.props.save)}
              numero="numero"
              descricao="descricao"
              ativo="ativo"
              salvarDisabled={submitting || this.props.loading}
              limparDisabled={pristine || submitting || this.props.loading}
              buttonLimpar
              reset={reset}
            />
          </ContentHolder>
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Cargo.resposta,
  tipoResposta: state.Cargo.tipoResposta,
  loading: state.Cargo.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    save: actions.save,
    clearResposta: actions.clearResposta,
  }, dispatch
);

AdminCargoNew = reduxForm({
  form: 'AdminCargoForm',
  validate,
})(AdminCargoNew);

export default (connect(mapStateToProps, mapDispatchToProps)(AdminCargoNew));