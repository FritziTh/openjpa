/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.jdbc.kernel.exps;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.openjpa.kernel.Filters;

/**
 * Floor value.
 */
public class Floor
    extends UnaryOp {

    
    private static final long serialVersionUID = 1L;

    /**
     * Constructor. Provide the value to operate on.
     */
    public Floor(Val val) {
        super(val);
    }

    @Override
    protected Class getType(Class c) {
        Class wrap = Filters.wrap(c);
        if (wrap == Integer.class
            || wrap == Float.class
            || wrap == Double.class
            || wrap == Long.class
            || wrap == BigDecimal.class
            || wrap == BigInteger.class) {
            return Filters.unwrap(c);
        }
        return int.class;
    }

    @Override
    protected String getOperator() {
        return "FLOOR";
    }

    @Override
    public int getId() {
        return Val.FLOOR_VAL;
    }
}

