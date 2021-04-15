#!/usr/bin/env node
import 'source-map-support/register';
import * as cdk from '@aws-cdk/core';
import {TasklistStack} from '../lib/tasklist-stack';

const app = new cdk.App();
new TasklistStack(app, 'TasklistStack', {
    description: 'stack for sample application. Created by yapoo.',
    env: {
        region: 'ap-northeast-1'
    }
});
