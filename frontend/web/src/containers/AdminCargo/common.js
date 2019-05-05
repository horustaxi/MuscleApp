import React, { Component } from 'react';
import { Link } from "react-router-dom";
import { Field } from 'redux-form'
import { Button, Row, Col } from 'antd';
import {
  TextField,
  SwitchField,
} from 'redux-form-antd'

export class Form extends Component {
  render() {

    const colStyle = {
      marginBottom: '16px'
    };

    return (
      <form onSubmit={this.props.onSubmit}>
        { this.props.id ?
          <Field name={this.props.id} component="input" type="hidden" />
          : ""
        }
        <Row gutter={16}>
          <Col md={12} sm={12} xs={24} style={colStyle}>
            <b>Número</b>
            <Field name={this.props.numero} component={TextField} />
          </Col>
          <Col md={12} sm={12} xs={24} style={colStyle}>
            <b>Descrição</b>
            <Field name={this.props.descricao} component={TextField} />
          </Col>
          <Col md={6} sm={12} xs={24} style={colStyle}>
            <Field name={this.props.ativo} component={SwitchField}
            checkedChildren={'Ativo'}
            unCheckedChildren={'Inativo'} />
          </Col>
        </Row>
        <Button type="primary" htmlType="submit" disabled={this.props.salvarDisabled}>
          Salvar Alteração
        </Button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <Link to={`/dashboard/admin-cargo/`}>
          <Button type="danger">
            Cancelar
          </Button>
        </Link>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        { this.props.buttonNovo ?
          <Link to={`/dashboard/admin-cargo/new`}>
            <Button type="secondary" disabled={this.props.novoDisabled}>
              Novo
            </Button>
          </Link>
          :
          this.props.buttonLimpar ?
          <Button type="secondary" disabled={this.props.limparDisabled} onClick={this.props.reset}>
            Limpar
          </Button>
          : ""
        }
      </form>
    );
  }
}

export const validate = (values) => {
  const errors = {};

  if (!values.descricao) {
    errors.descricao = "Prenchimento obrigatório";
  }
  if (!values.numero) {
    errors.numero = "Prenchimento obrigatório";
  } else if (isNaN(Number(values.numero))) {
    errors.numero = "Apenas números";
  }

  return errors;
}