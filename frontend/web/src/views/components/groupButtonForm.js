import React from 'react';
import { Button } from 'antd';

const GroupButtonForm = ({
  disableSubmitButton,
  loading,
  submitButtonText,
  disableCancelButton,
  onClickCancel,
  cancelButtonText,
  disableClearButton,
  onClickClear,
  clearButtonText,
}) => (
  <div>
    <Button type="primary" htmlType="submit" disabled={disableSubmitButton} loading={loading}>
      {submitButtonText}
    </Button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <Button type="danger" disabled={disableCancelButton} onClick={onClickCancel}>
      {cancelButtonText}
    </Button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <Button type="secondary" disabled={disableClearButton} onClick={onClickClear}>
      {clearButtonText}
    </Button>
  </div>
);

export default GroupButtonForm;
