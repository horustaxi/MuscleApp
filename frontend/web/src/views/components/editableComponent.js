import React, { useState } from 'react';
import { Icon, Textarea as Input } from 'antd';

const EditableComponent = ({ value: initialValue, onChange, itemKey }) => {
  const [value, setValue] = useState(initialValue);
  const [editable, setEditable] = useState(false);

  const handleChange = (event) => {
    setValue(event.target.value);
  };
  const check = () => {
    setEditable(false);
    if (onChange) {
      onChange(itemKey, value);
    }
  };
  const edit = () => {
    setEditable(true);
  };

  return (
    <div className="isoNoteContent">
      {editable ? (
        <div className="isoNoteEditWrapper">
          <Input rows={3} value={value} onChange={handleChange} onPressEnter={check} />
          <Icon type="check" className="isoNoteEditIcon" onClick={check} />
        </div>
      ) : (
        <p className="isoNoteTextWrapper" onClick={edit}>
          {value || ' '}
          <Icon type="edit" className="isoNoteEditIcon" />
        </p>
      )}
    </div>
  );
};
export default EditableComponent;
