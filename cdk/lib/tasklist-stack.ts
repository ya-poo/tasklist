import * as cdk from '@aws-cdk/core';
import {Repository, TagStatus} from "@aws-cdk/aws-ecr";

export class TasklistStack extends cdk.Stack {
    constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        new Repository(this, 'TasklistRepository', {
            repositoryName: 'tasklist',
            lifecycleRules: [{
                description: 'images retain 90 days',
                maxImageAge: cdk.Duration.days(90),
                tagStatus: TagStatus.ANY
            }]
        })
    }
}
