import React from 'react';
import { BoxTitle, BoxSubTitle } from './boxTitle.style';

export default ({ title, subtitle }) => (
  <div>
    {title ? (
      <BoxTitle className="isoBoxTitle">
        {' '}
        {title}
        {' '}
      </BoxTitle>
    ) : ''}
    {subtitle ? (
      <BoxSubTitle className="isoBoxSubTitle">
        {' '}
        {subtitle}
        {' '}
      </BoxSubTitle>
    ) : ''}
  </div>
);
