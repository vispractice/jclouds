/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.cloudstack.response;

import java.io.Serializable;
import java.util.List;

public class ExceptionResponse implements Serializable{

    private List<ExceptionProxyObject> idList;

    private Integer errorCode;

    private Integer csErrorCode;

    private String errorText;

    public List<ExceptionProxyObject> getIdList() {
        return idList;
    }

    public void setIdList(List<ExceptionProxyObject> idList) {
        this.idList = idList;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getCsErrorCode() {
        return csErrorCode;
    }

    public void setCsErrorCode(Integer csErrorCode) {
        this.csErrorCode = csErrorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public String toString() {
        return "ExceptionResponse [idList=" + idList + ", errorCode="
                + errorCode + ", csErrorCode=" + csErrorCode + ", errorText="
                + errorText + "]";
    }
}
