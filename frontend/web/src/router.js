import React from 'react';
import { Route, Redirect, Switch } from 'react-router-dom';
import { ConnectedRouter } from 'connected-react-router';
import { connect } from 'react-redux';

import App from './views/containers/App/App';
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
  <ConnectedRouter history={history}>
    <Switch>
      <Route
        exact
        path="/"
        component={asyncComponent(() => import('./views/containers/Page/signin'))}
      />
      <Route
        exact
        path="/signin"
        component={asyncComponent(() => import('./views/containers/Page/signin'))}
      />
      <RestrictedRoute path="/dashboard" component={App} isLoggedIn={isLoggedIn} />
    </Switch>
  </ConnectedRouter>
);

const mapStateToProps = state => ({
  isLoggedIn: state.Auth.get('idToken') !== null,
});

export default connect(mapStateToProps)(PublicRoutes);
