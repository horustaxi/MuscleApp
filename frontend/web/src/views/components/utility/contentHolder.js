import React from 'react';
import { ContentHolderWrapper } from './contentHolder.style';

export default ({ style, children }) => (
  <ContentHolderWrapper className="isoExampleWrapper" style={style}>
    {children}
  </ContentHolderWrapper>
);
