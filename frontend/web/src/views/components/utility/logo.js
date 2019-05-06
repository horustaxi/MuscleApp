import React from 'react';
import { Link } from 'react-router-dom';
import { siteConfig } from '../../../settings';
import logo from '../../../image/logo.png';

export default ({ collapsed }) => (
  <div className="isoLogoWrapper">
    {collapsed ? (
      <div>
        <h3>
          <Link to="/dashboard">
            <img src={logo} alt="Smiley face" height="42" width="42" />
            {/* <i className={siteConfig.siteIcon} /> */}
          </Link>
        </h3>
      </div>
    ) : (
      <h3>
        <Link to="/dashboard">{siteConfig.siteName}</Link>
      </h3>
    )}
  </div>
);
