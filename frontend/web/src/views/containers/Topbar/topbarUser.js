import React, { useState } from 'react';
import { connect } from 'react-redux';
import { Popover } from 'antd';
import userpic from '../../../image/user1.png';
import authAction from '../../../redux/auth/actions';
import TopbarDropdownWrapper from './topbarDropdown.style';

const TopbarUser = ({ logout }) => {
  const [visible, setVisible] = useState(false);

  const handleVisibleChange = () => {
    setVisible(!visible);
  };

  const content = (
    <TopbarDropdownWrapper className="isoUserDropdown">
      <a className="isoDropdownLink" onClick={logout}>
        Sair
      </a>
    </TopbarDropdownWrapper>
  );

  return (
    <Popover
      content={content}
      trigger="click"
      visible={visible}
      onVisibleChange={handleVisibleChange}
      arrowPointAtCenter
      placement="bottomLeft"
    >
      <div className="isoImgWrapper">
        <img alt="user" src={userpic} />
        <span className="userActivity online" />
      </div>
    </Popover>
  );
};
export default connect(
  null,
  { logout: authAction.logout },
)(TopbarUser);
