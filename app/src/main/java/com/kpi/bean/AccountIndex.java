package com.kpi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class AccountIndex {

    /**
     * dataListAsc : [{"condition":null,"count":19,"countMom":null,"customerId":"CU160100001606","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":16,"countMom":null,"customerId":"CU160300037901","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":13,"countMom":null,"customerId":"CU160100000533","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":12,"countMom":null,"customerId":"CU160200029764","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":12,"countMom":null,"customerId":"CU160300074749","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160100001928","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200017428","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160100003164","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200033274","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200015709","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null}]
     * msg : 成功
     */

    private DataEntity data;
    /**
     * data : {"dataListAsc":[{"condition":null,"count":19,"countMom":null,"customerId":"CU160100001606","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":16,"countMom":null,"customerId":"CU160300037901","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":13,"countMom":null,"customerId":"CU160100000533","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":12,"countMom":null,"customerId":"CU160200029764","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":12,"countMom":null,"customerId":"CU160300074749","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160100001928","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200017428","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160100003164","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200033274","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null},{"condition":null,"count":11,"countMom":null,"customerId":"CU160200015709","database":null,"ddate":null,"ddatefrom":null,"ddatefromMom":null,"ddateto":null,"ddatetoMom":null,"order":null,"pageCount":null,"pageStart":null}],"msg":"成功"}
     * success : true
     */

    private boolean success;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity {
        private String msg;
        /**
         * condition : null
         * count : 19
         * countMom : null
         * customerId : CU160100001606
         * database : null
         * ddate : null
         * ddatefrom : null
         * ddatefromMom : null
         * ddateto : null
         * ddatetoMom : null
         * order : null
         * pageCount : null
         * pageStart : null
         */

        private List<DataListAscEntity> dataListAsc;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataListAscEntity> getDataListAsc() {
            return dataListAsc;
        }

        public void setDataListAsc(List<DataListAscEntity> dataListAsc) {
            this.dataListAsc = dataListAsc;
        }

        public static class DataListAscEntity {
            private Object condition;
            private int count;
            private Object countMom;
            private String customerId;
            private Object database;
            private Object ddate;
            private Object ddatefrom;
            private Object ddatefromMom;
            private Object ddateto;
            private Object ddatetoMom;
            private Object order;
            private Object pageCount;
            private Object pageStart;

            public Object getCondition() {
                return condition;
            }

            public void setCondition(Object condition) {
                this.condition = condition;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getCountMom() {
                return countMom;
            }

            public void setCountMom(Object countMom) {
                this.countMom = countMom;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public Object getDatabase() {
                return database;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public Object getDdate() {
                return ddate;
            }

            public void setDdate(Object ddate) {
                this.ddate = ddate;
            }

            public Object getDdatefrom() {
                return ddatefrom;
            }

            public void setDdatefrom(Object ddatefrom) {
                this.ddatefrom = ddatefrom;
            }

            public Object getDdatefromMom() {
                return ddatefromMom;
            }

            public void setDdatefromMom(Object ddatefromMom) {
                this.ddatefromMom = ddatefromMom;
            }

            public Object getDdateto() {
                return ddateto;
            }

            public void setDdateto(Object ddateto) {
                this.ddateto = ddateto;
            }

            public Object getDdatetoMom() {
                return ddatetoMom;
            }

            public void setDdatetoMom(Object ddatetoMom) {
                this.ddatetoMom = ddatetoMom;
            }

            public Object getOrder() {
                return order;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public Object getPageCount() {
                return pageCount;
            }

            public void setPageCount(Object pageCount) {
                this.pageCount = pageCount;
            }

            public Object getPageStart() {
                return pageStart;
            }

            public void setPageStart(Object pageStart) {
                this.pageStart = pageStart;
            }
        }
    }
}
