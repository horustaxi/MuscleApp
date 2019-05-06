import React from 'react';
import { EmptyComponent } from './emptyComponent.style';

export default ({ value }) => (
  <EmptyComponent className="isoEmptyComponent">
    <span>{value || 'Please include Config'}</span>
  </EmptyComponent>
);
