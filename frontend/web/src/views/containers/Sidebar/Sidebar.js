import React, { Component } from 'react';
import { connect } from 'react-redux';
import clone from 'clone';
import { Link } from 'react-router-dom';
import { Layout, Menu } from 'antd';
import Scrollbar from 'react-smooth-scrollbar';
import options from './options';
import SidebarWrapper from './sidebar.style';
import appActions from '../../../redux/app/actions';
import Logo from '../../components/utility/logo';
import themes from '../../../settings/themes';
import { themeConfig } from '../../../settings';

const { SubMenu } = Menu;
const { Sider } = Layout;

const {
  toggleOpenDrawer, changeOpenKeys, changeCurrent, toggleCollapsed,
} = appActions;
const stripTrailingSlash = (str) => {
  if (str.substr(-1) === '/') {
    return str.substr(0, str.length - 1);
  }
  return str;
};

class Sidebar extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
    this.onOpenChange = this.onOpenChange.bind(this);
  }

  handleClick(e) {
    this.props.changeCurrent([e.key]);
    if (this.props.app.view === 'MobileView') {
      setTimeout(() => {
        this.props.toggleCollapsed();
        this.props.toggleOpenDrawer();
      }, 100);
    }
  }

  onOpenChange(newOpenKeys) {
    const { app, changeOpenKeys } = this.props;
    const latestOpenKey = newOpenKeys.find(key => !(app.openKeys.indexOf(key) > -1));
    const latestCloseKey = app.openKeys.find(key => !(newOpenKeys.indexOf(key) > -1));
    let nextOpenKeys = [];
    if (latestOpenKey) {
      nextOpenKeys = this.getAncestorKeys(latestOpenKey).concat(latestOpenKey);
    }
    if (latestCloseKey) {
      nextOpenKeys = this.getAncestorKeys(latestCloseKey);
    }
    changeOpenKeys(nextOpenKeys);
  }

  getAncestorKeys = (key) => {
    const map = {
      sub3: ['sub2'],
    };
    return map[key] || [];
  };

  getMenuItem = ({ singleOption, submenuStyle, submenuColor }) => {
    const {
      key, label, leftIcon, children,
    } = singleOption;
    const url = stripTrailingSlash(this.props.url);
    if (children) {
      return (
        <SubMenu
          key={key}
          title={(
            <span className="isoMenuHolder" style={submenuColor}>
              <i className={leftIcon} />
              <span className="nav-text">{label}</span>
            </span>
)}
        >
          {children.map((child) => {
            const linkTo = child.withoutDashboard ? `/${child.key}` : `${url}/${child.key}`;
            return (
              <Menu.Item style={submenuStyle} key={child.key}>
                <Link style={submenuColor} to={linkTo}>
                  {child.label}
                </Link>
              </Menu.Item>
            );
          })}
        </SubMenu>
      );
    }
    return (
      <Menu.Item key={key}>
        <Link to={`${url}/${key}`}>
          <span className="isoMenuHolder" style={submenuColor}>
            <i className={leftIcon} />
            <span className="nav-text">{label}</span>
          </span>
        </Link>
      </Menu.Item>
    );
  };

  render() {
    const { app, toggleOpenDrawer, height } = this.props;
    const collapsed = clone(app.collapsed) && !clone(app.openDrawer);
    const { openDrawer } = app;
    const mode = collapsed === true ? 'vertical' : 'inline';
    const onMouseEnter = (event) => {
      if (openDrawer === false) {
        toggleOpenDrawer();
      }
    };
    const onMouseLeave = () => {
      if (openDrawer === true) {
        toggleOpenDrawer();
      }
    };
    const customizedTheme = themes[themeConfig.theme];
    const styling = {
      backgroundColor: '#a0be4d', // customizedTheme.backgroundColor
    };
    const submenuStyle = {
      backgroundColor: 'rgba(0,0,0,0.3)',
      color: customizedTheme.textColor,
    };
    const submenuColor = {
      color: customizedTheme.textColor,
    };
    return (
      <SidebarWrapper>
        <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          width="300"
          className="isomorphicSidebar"
          onMouseEnter={onMouseEnter}
          onMouseLeave={onMouseLeave}
          style={styling}
        >
          <Logo collapsed={collapsed} />
          <Scrollbar style={{ height: height - 70 }}>
            <Menu
              onClick={this.handleClick}
              theme="dark"
              className="isoDashboardMenu"
              mode={mode}
              openKeys={collapsed ? [] : app.openKeys}
              selectedKeys={app.current}
              onOpenChange={this.onOpenChange}
            >
              {options.map(singleOption => this.getMenuItem({ submenuStyle, submenuColor, singleOption }))}
            </Menu>
          </Scrollbar>
        </Sider>
      </SidebarWrapper>
    );
  }
}

export default connect(
  state => ({
    app: state.App.toJS(),
    height: state.App.toJS().height,
  }),
  {
    toggleOpenDrawer,
    changeOpenKeys,
    changeCurrent,
    toggleCollapsed,
  },
)(Sidebar);
