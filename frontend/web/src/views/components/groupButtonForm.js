import React, { Component } from 'react';
import { Button } from 'antd';

export default class GroupButtonForm extends Component {
  render() {
    return (
      <div>
        <Button
          type="primary"
          htmlType="submit"
          disabled={this.props.disableSubmitButton}
          loading={this.props.loading}
        >
          {this.props.submitButtonText}
        </Button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <Button
          type="danger"
          disabled={this.props.disableCancelButton}
          onClick={this.props.onClickCancel}
        >
          {this.props.cancelButtonText}
        </Button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <Button
          type="secondary"
          disabled={this.props.disableClearButton}
          onClick={this.props.onClickClear}
        >
          {this.props.clearButtonText}
        </Button>
      </div>
    );
  }
}
