import React, { Component, } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Table, Spin, Alert, Select, Form, Button, Input, InputNumber, Switch, Row, Col } from 'antd';
import Box from '../../components/utility/box';
import PageHeader from '../../components/utility/pageHeader';
import GroupButtonForm from '../../components/groupButtonForm';
import LayoutContent from '../../components/utility/layoutContent';
import ContentHolder from '../../components/utility/contentHolder';
import actions from '../../redux/fazenda/actions';
import actionsFilial from '../../redux/filial/actions';
import actionsEmpresa from '../../redux/empresa/actions';
const FormItem = Form.Item;
const Option = Select.Option;

class AdminFazendaNew extends Component {

  constructor(props) {
    super(props);
    this.state = {
      numeroSecao: '',
      numeroTalhao: '',
    };
  }
  

  componentWillMount() {
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
  }

  onChangeSecao = (value) => this.setState({ numeroSecao: value });
  onChangeTalhao = (value) => {
    this.setState({ numeroTalhao: value })
  };

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

    const { getFieldDecorator, getFieldValue } = this.props.form;

    const talhoesColumns = [
      {
        title: 'Número', dataIndex: 'numero', key: 'numero',
      }
    ];

    const secoesColumns = [
      {
        title: 'Número', dataIndex: 'numero', key: 'numero',
      },
      {
        title: 'Talhões', dataIndex: 'nome', key: 'nome',
        render: (text, record) => (
          <Box>
            <b>Número do Talhão</b><br/>
            <InputNumber style={{ width: '70%' }}
              onChange={this.onChangeTalhao}
              ref={el => this.inputTalhao = el}
            />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Button onClick={() => {
              record.talhoes = record.talhoes.concat({ numero: this.state.numeroTalhao })
              this.onChangeTalhao('');
            }}>
              Adicionar
            </Button>
            <Table
              pagination={false}
              columns={talhoesColumns}
              dataSource={record.talhoes}
            />
          </Box>
        ),
      }
    ];

    const colStyle = {
      marginBottom: '16px'
    };

    if (this.props.tipoResposta === 'success') {
      this.props.history.push('/dashboard/admin-fazenda');
    }

    const optionsEmpresas = this.props.empresas ?
      this.props.empresas
      .filter(empresa => empresa.ativo)
      .map(empresa => 
        (<Option value={empresa.id} key={empresa.id}>{empresa.cnpj+' - '+empresa.razaoSocial}</Option>)
      )
      : '';
    
    const optionsFiliais = this.props.filiais ?
      this.props.filiais
      .filter(filial => filial.ativo)
      .map(filial => 
        (<Option value={filial.id} key={filial.id}>{filial.cnpj+' - '+filial.razaoSocial}</Option>)
      )
      : '';

    getFieldDecorator('secoes', { initialValue: [] });

    return (
      <LayoutContent>        
        <PageHeader>Fazenda &nbsp;&nbsp; {this.props.loading ? <Spin/> : ''}</PageHeader>
          {this.renderAlert()}
          <Box title="Cadastro">
          <ContentHolder>
            <Form onSubmit={this.handleSubmit}>
              <Row gutter={16}>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Nome</b>
                  <FormItem>
                    {getFieldDecorator('nome', {
                      rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                    })(
                    <Input />
                    )}
                  </FormItem>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Número</b>
                  <FormItem>
                    {getFieldDecorator('numero', {
                      rules: [
                        // { type: 'integer', message: 'Matrícula deve ser um número!' },
                        { required: true, message: 'Preenchimento obrigatório!' },
                      ],
                    })(
                    <InputNumber style={{ width: '90%' }} />
                    )}
                  </FormItem>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Empresa</b><br/>
                  <FormItem>
                    {getFieldDecorator('empresa.id', {
                      rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                    })(
                    <Select
                      showSearch
                      style={{ width: '90%' }}
                      placeholder="Selecione..."
                      optionFilterProp="children"
                      filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                    >
                      {optionsEmpresas}
                    </Select>
                    )}
                  </FormItem>
                </Col>
                <Col md={12} sm={12} xs={24} style={colStyle}>
                  <b>Filial</b><br/>
                  <FormItem>
                    {getFieldDecorator('filial.id', {
                      rules: [{ required: true, message: 'Preenchimento obrigatório!' }],
                    })(
                    <Select
                      showSearch
                      style={{ width: '90%' }}
                      placeholder="Selecione..."
                      optionFilterProp="children"
                      filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                    >
                      {optionsFiliais}
                    </Select>
                    )}
                  </FormItem>
                </Col>
                <Col md={24} sm={24} xs={24} style={colStyle}>
                  <Box title="Seções">
                    <b>Número da Seção</b><br/>
                    <InputNumber style={{ width: '70%' }}
                      value={this.state.numeroSecao}
                      onChange={this.onChangeSecao}
                    />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Button onClick={() => {
                      const { getFieldValue, setFieldsValue } = this.props.form;
                      setFieldsValue({
                        secoes: getFieldValue('secoes').concat({ numero: this.state.numeroSecao, talhoes: [] })
                      });                      
                      this.onChangeSecao('');
                    }}>
                      Adicionar
                    </Button>
                    <Table
                      pagination={false}
                      columns={secoesColumns}
                      dataSource={getFieldValue('secoes')}
                    />
                  </Box>
                </Col>
                <Col md={6} sm={12} xs={24} style={colStyle}>
                  <b>Status</b>
                  <FormItem>
                    {getFieldDecorator('ativo', { initialValue: true })(
                    <Switch
                      checkedChildren={'Ativo'}
                      unCheckedChildren={'Inativo'}
                      defaultChecked
                    />
                    )}
                  </FormItem>
                </Col>
              </Row>              
              <GroupButtonForm
                disableSubmitButton={this.props.loading}
                submitButtonText="Salvar"
                disableCancelButton={this.props.loading}
                onClickCancel={() => this.props.history.push('/dashboard/admin-fazenda/')}
                cancelButtonText="Cancelar"
                disableClearButton={this.props.loading}
                onClickClear={() => this.props.form.resetFields()}
                clearButtonText="Limpar"
              />
            </Form>
          </ContentHolder>
          </Box>
      </LayoutContent>
    );
  }
}

const mapStateToProps = state => ({
  resposta: state.Fazenda.resposta,
  tipoResposta: state.Fazenda.tipoResposta,
  loading: state.Fazenda.loading,
  filiais: state.Filial.all,
  empresas: state.Empresa.all,
});

const mapDispatchToProps = dispatch => bindActionCreators(
  {
    save: actions.save,
    clearResposta: actions.clearResposta,
    fetchAllFiliais: actionsFilial.fetchAll,
    fetchAllEmpresas: actionsEmpresa.fetchAll,
  }, dispatch
);
AdminFazendaNew = Form.create()(AdminFazendaNew);
export default connect(mapStateToProps, mapDispatchToProps)(AdminFazendaNew);