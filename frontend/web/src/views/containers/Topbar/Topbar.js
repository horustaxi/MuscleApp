import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Layout } from 'antd';
import appActions from '../../../redux/app/actions';
import TopbarUser from './topbarUser';
import TopbarWrapper from './topbar.style';
import themes from '../../../settings/themes';
import { themeConfig } from '../../../settings';

const { Header } = Layout;
const customizedTheme = themes[themeConfig.theme];

const Topbar = ({ toggleCollapsed, collapsed, openDrawer }) => {
  const isCollapsed = collapsed && !openDrawer;
  const styling = {
    background: customizedTheme.backgroundColor,
    position: 'fixed',
    width: '100%',
    height: 70,
  };
  return (
    <TopbarWrapper>
      <Header
        style={styling}
        className={isCollapsed ? 'isomorphicTopbar collapsed' : 'isomorphicTopbar'}
      >
        <div className="isoLeft" style={{ marginLeft: 50 }}>
          <button
            className={isCollapsed ? 'triggerBtn menuCollapsed' : 'triggerBtn menuOpen'}
            style={{ color: customizedTheme.textColor }}
            onClick={toggleCollapsed}
          />
        </div>

        <ul className="isoRight">
          <li onClick={() => {}} className="isoUser">
            <TopbarUser />
          </li>
        </ul>
      </Header>
    </TopbarWrapper>
  );
};

export default connect(
  state => ({
    ...state.App.toJS(),
  }),
  { toggleCollapsed: appActions.toggleCollapsed },
)(Topbar);
