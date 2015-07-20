/*
  Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.api.x;

import java.util.Arrays;
import java.util.List;

public interface TableStatement<STMT_T, RES_T> extends Statement<STMT_T, RES_T> {

    interface DeleteStatement extends TableStatement<DeleteStatement, Result> {
        DeleteStatement where(String searchCondition);

        DeleteStatement orderBy(String sortFields);

        DeleteStatement limit(long numberOfRows);
    }

    interface UpdateStatement extends TableStatement<UpdateStatement, Result> {
        UpdateStatement set(String fieldsAndValues);

        UpdateStatement where(String searchCondition);

        UpdateStatement orderBy(String sortFields);

        UpdateStatement limit(long numberOfRows);
    }

    interface InsertStatement extends TableStatement<UpdateStatement, Result> {
        InsertStatement values(List<Object> values);

        default InsertStatement values(Object[] values) {
            return values(Arrays.asList(values));
        }
    }

    interface SelectStatement extends TableStatement<SelectStatement, FetchedRows> {
        SelectStatement where(String searchCondition);

        SelectStatement groupBy(String groupBy);

        SelectStatement having(String having);

        SelectStatement orderBy(String sortFields);

        SelectStatement limit(long numberOfRows);

        SelectStatement offset(long limitOffset);

        //SelectStatement fetch(Object callback); // not supported in v1
    }
}
