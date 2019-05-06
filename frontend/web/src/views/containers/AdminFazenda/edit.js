import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import {
  Spin, Alert, Select, Form, Input, InputNumber, Switch, Row, Col,
} from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import LayoutContent from '../../components/utility/layoutContent';
import ContentHolder from '../../components/utility/contentHolder';
import GroupButtonForm from '../../components/groupButtonForm';
import actions from '../../../redux/fazenda/actions';
import actionsFilial from '../../../redux/filial/actions';
import actionsEmpresa from '../../../redux/empresa/actions';

const FormItem = Form.Item;
const { Option } = Select;

class AdminFazendaNew extends Component {
  componentWillMount() {
    this.props.fetchOne(this.props.match.params.id);
    this.props.fetchAllEmpresas();
    this.props.fetchAllFiliais();
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
        this.props.save(values);
      }
    });
  };

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
          <br />
        </div>
      );
    }
  }

  render() {
    const { getFieldDecorator, getFieldValue } = this.props.form;
    const usuario = this.props.usuario || {};

    const colStyle = {
      marginBottom: '16px',
    };

    if (this.props.tipoResposta === 'success') {
      this.props.history.push('/dashboard/admin-usuario');
    }

    const optionsFiliais = this.props.filiais
      ? this.props.filiais
        .filter(filial => filial.ativo)
        .map(filial => (
          <Option value={filial.id} key={filial.id}>
            {`${filial.cnpj} - ${filial.razaoSocial}`}
          </Option>
        ))
      : '';
    const optionsCargos = this.props.cargos
      ? this.props.cargos
        .filter(cargo => cargo.ativo)
        .map(cargo => (
          <Option value={cargo.id} key={cargo.id}>
            {`${cargo.numero} - ${cargo.descricao}`}
          </Option>
        ))
      : '';

    return (
      <LayoutContent>
        <PageHeader>
Usuário &nbsp;&nbsp;
          {this.props.loading ? <Spin /> : ''}
        </PageHeader>
        {this.renderAlert()}
        <Box title="Cadastro">
          <ContentHolder>
            <Form onSubmit={this.handleSubmit}>
              <Row gutter={16}>
                <FormItem>
                  {getFieldDecorator('id', { initialValue: usuario.id })(<Input type="hidden" />)}
                </FormItem>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Nome</b>
                  <FormItem>
                    {getFieldDecorator('name', {
                      initialValue: usuario.name,
                      rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                    })(<Input />)}
                  </FormItem>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Email</b>
                  <FormItem>
                    {getFieldDecorator('email', {
                      initialValue: usuario.email,
                      rules: [
                        { type: 'email', message: 'Email invalido!' },
                        { required: true, message: 'Preenchimento obrigatório!' },
                      ],
                    })(<Input />)}
                  </FormItem>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Senha</b>
                  <FormItem>{getFieldDecorator('password')(<Input type="password" />)}</FormItem>
                </Col>
                <Col md={6} sm={12} xs={24} style={colStyle}>
                  <b>Status</b>
                  <FormItem>
                    {getFieldDecorator('ativo', { initialValue: usuario.ativo })(
                      <Switch
                        checkedChildren="Ativo"
                        unCheckedChildren="Inativo"
                        defaultChecked
                        checked={getFieldValue('ativo')}
                      />,
                    )}
                  </FormItem>
                </Col>
                <Col md={6} sm={12} xs={24} style={colStyle}>
                  <b>É Funcionário?</b>
                  <FormItem>
                    {getFieldDecorator('isFuncionario', {
                      initialValue: !!(usuario.funcionario && usuario.funcionario.ativo),
                    })(
                      <Switch
                        checkedChildren="Sim"
                        unCheckedChildren="Não"
                        checked={getFieldValue('isFuncionario')}
                      />,
                    )}
                  </FormItem>
                </Col>
              </Row>
              {getFieldValue('isFuncionario') ? (
                <Box title="Dados do Funcionário">
                  <ContentHolder>
                    <Row gutter={16}>
                      <Col md={12} sm={12} xs={24} style={colStyle}>
                        <b>Filial</b>
                        <br />
                        <FormItem>
                          {getFieldDecorator('funcionario.filial.id', {
                            initialValue: usuario.funcionario.filial.id,
                            rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                          })(
                            <Select
                              showSearch
                              style={{ width: '90%' }}
                              placeholder="Selecione..."
                              optionFilterProp="children"
                              filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase())
                                >= 0
                              }
                            >
                              {optionsFiliais}
                            </Select>,
                          )}
                        </FormItem>
                      </Col>
                      <Col md={12} sm={12} xs={24} style={colStyle}>
                        <b>Matrícula</b>
                        <FormItem>
                          {getFieldDecorator('funcionario.matricula', {
                            initialValue: usuario.funcionario.matricula,
                            rules: [
                              // { type: 'integer', message: 'Matrícula deve ser um número!' },
                              { required: true, message: 'Preenchimento obrigatório!' },
                            ],
                          })(<InputNumber style={{ width: '90%' }} />)}
                        </FormItem>
                      </Col>
                      <Col md={12} sm={12} xs={24} style={colStyle}>
                        <b>Cargo</b>
                        <br />
                        <FormItem>
                          {getFieldDecorator('funcionario.cargo.id', {
                            initialValue: usuario.funcionario.cargo.id,
                            rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                          })(
                            <Select
                              showSearch
                              style={{ width: '90%' }}
                              placeholder="Selecione..."
                              optionFilterProp="children"
                              filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase())
                                >= 0
                              }
                            >
                              {optionsCargos}
                            </Select>,
                          )}
                        </FormItem>
                      </Col>
                    </Row>
                  </ContentHolder>
                </Box>
              ) : (
                ''
              )}
              <GroupButtonForm
                disableSubmitButton={this.props.loading}
                submitButtonText="Salvar Alteração"
                disableCancelButton={this.props.loading}
                onClickCancel={() => this.props.history.push('/dashboard/admin-usuario/')}
                cancelButtonText="Cancelar"
                disableClearButton={this.props.loading}
                onClickClear={() => this.props.history.push('/dashboard/admin-usuario/new')}
                clearButtonText="Novo"
              />
            </Form>
          </ContentHolder>
        </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  usuario: state.Usuario.usuario,
  resposta: state.Usuario.resposta,
  tipoResposta: state.Usuario.tipoResposta,
  loading: state.Usuario.loading,
  filiais: state.Filial.all,
  cargos: state.Cargo.all,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    save: actions.save,
    fetchOne: actions.fetchOne,
    clearResposta: actions.clearResposta,
    fetchAllFiliais: actionsFilial.fetchAll,
    fetchAllEmpresas: actionsEmpresa.fetchAll,
  },
  dispatch,
);
AdminFazendaNew = Form.create()(AdminFazendaNew);
export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(AdminFazendaNew);
