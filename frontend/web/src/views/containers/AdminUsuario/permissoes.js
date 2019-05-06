import React, { Component } from 'react';
import { Transfer } from 'antd';

class Permissoes extends Component {
  state = {
    selectedKeys: [],
  }

  handleSelectChange = (sourceSelectedKeys, targetSelectedKeys) => {
    this.setState({ selectedKeys: [...sourceSelectedKeys, ...targetSelectedKeys] });
  }

  render() {
    const state = this.state;
    const targetKeys = this.props.permissoesUsuario;
    const data = this.props.permissoes.map(permissao => {
      return {
        key: permissao.id,
        title: permissao.applicationPlatform + ' - ' + permissao.modulo,
      }
    });
    return (
      <Transfer
        listStyle={{
          width: 360,
          height: 400,
        }}
        showSearch
        dataSource={data}
        titles={['Disponíveis', 'Selecionados']}
        targetKeys={targetKeys}
        selectedKeys={state.selectedKeys}
        onChange={this.props.handleChange}
        onSelectChange={this.handleSelectChange}
        onScroll={this.handleScroll}
        render={item => item.title}
      />
    );
  }
};

export default Permissoes;
