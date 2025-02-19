/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ext.firebird.model.plan;

import org.jkiss.dbeaver.model.exec.plan.DBCPlanNode;
import org.jkiss.dbeaver.model.impl.plan.AbstractExecutionPlanNode;
import org.jkiss.dbeaver.model.meta.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Firebird plan node implementation.
 *
 * @author tomashorak@post.cz
 */
public class FireBirdPlanNode extends AbstractExecutionPlanNode {

	private String plan;
	FireBirdPlanNode parent;
	private List<FireBirdPlanNode> nested;
	
	public FireBirdPlanNode(String plan) {
		this.plan = plan;
		this.nested = new ArrayList<>();
	}

    @Property(order = 1, viewable = true)
	@Override
	public String getNodeName() {
		return plan;
	}

	@Override
	public String getNodeType() {
		return "Plan";
	}

	@Override
	public String getNodeDescription() {
		return plan;
	}

	@Override
	public DBCPlanNode getParent() {
		return parent;
	}

	@Override
	public Collection<FireBirdPlanNode> getNested() {
		return nested;
	}
	
	@Override
    public String toString()
    {
        return plan;
    }
}
