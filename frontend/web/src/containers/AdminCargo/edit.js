import React, { Component, } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { reduxForm } from 'redux-form'
import { Spin, Alert } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import ContentHolder from '../../components/utility/contentHolder';
import actions from '../../redux/cargo/actions';
import { Form, validate } from './common';

class AdminCargoEdit extends Component {

  componentDidMount() {
    this.props.fetchOne(this.props.match.params.id);
  }

  renderAlert() {
    if (this.props.tipoResposta) {
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
    
    const { handleSubmit, submitting, pristine } = this.props;

    return (
      <LayoutContent>        
        <PageHeader>Cargo &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Box title="Edição">
          <ContentHolder>
            <Form
              onSubmit={handleSubmit(this.props.save)}
              id="id"
              numero="numero"
              descricao="descricao"
              ativo="ativo"
              salvarDisabled={pristine || submitting || this.props.loading}
              novoDisabled={submitting || this.props.loading}
              buttonNovo
            />
          </ContentHolder>
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  initialValues: state.Cargo.cargo,
  resposta: state.Cargo.resposta,
  tipoResposta: state.Cargo.tipoResposta,
  loading: state.Cargo.loading,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    save: actions.save,
    fetchOne: actions.fetchOne,
    clearResposta: actions.clearResposta,
  }, dispatch
);

AdminCargoEdit = reduxForm({
  form: 'AdminCargoEditForm',
  validate,
  enableReinitialize : true,
})(AdminCargoEdit);

export default (connect(mapStateToProps, mapDispatchToProps)(AdminCargoEdit));