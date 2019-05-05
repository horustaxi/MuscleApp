import React from 'react';
import {
  BrowserRouter, Route, Redirect, Switch,
} from 'react-router-dom';
import { connect } from 'react-redux';

import App from './containers/App/App';
import asyncComponent from './helpers/AsyncFunc';

const RestrictedRoute = ({ component: Component, isLoggedIn, ...rest }) => (
  <Route
    {...rest}
    render={props => (isLoggedIn ? (
      <Component {...props} />
    ) : (
      <Redirect
        to={{
          pathname: '/signin',
          state: { from: props.location },
        }}
      />
    ))
    }
  />
);
const PublicRoutes = ({ history, isLoggedIn }) => (
  <BrowserRouter history={history}>
    <Switch>
      <Route exact path="/" component={asyncComponent(() => import('./containers/Page/signin'))} />
      <Route
        exact
        path="/signin"
        component={asyncComponent(() => import('./containers/Page/signin'))}
      />
      <RestrictedRoute path="/dashboard" component={App} isLoggedIn={isLoggedIn} />
    </Switch>
  </BrowserRouter>
);

const mapStateToProps = state => ({
  isLoggedIn: state.Auth.get('idToken') !== null,
});

export default connect(mapStateToProps)(PublicRoutes);
