package com.kpi.bean;

import java.util.List;


public class KpiTrend {


    /**
     * datato : 2016-03-23
     * datafrom : 2016-03-13
     * imgType : 1
     * data : null
     * searchType : 0
     * msg : 成功
     * lstKpiUrl : /image/output/openId/20160323/KPI002_20160323152808.gif
     * dataListDetail : [{"DDate":"20160313","DDatefrom":null,"DDateto":null,"addCount":3270,"customerCount":10441,"database":null,"dateMd":"03/13","dateYmd":"2016/03/13","scanCount":23633},{"DDate":"20160314","DDatefrom":null,"DDateto":null,"addCount":4303,"customerCount":12098,"database":null,"dateMd":"03/14","dateYmd":"2016/03/14","scanCount":25072},{"DDate":"20160315","DDatefrom":null,"DDateto":null,"addCount":4336,"customerCount":10405,"database":null,"dateMd":"03/15","dateYmd":"2016/03/15","scanCount":22204},{"DDate":"20160316","DDatefrom":null,"DDateto":null,"addCount":4539,"customerCount":13404,"database":null,"dateMd":"03/16","dateYmd":"2016/03/16","scanCount":30065},{"DDate":"20160317","DDatefrom":null,"DDateto":null,"addCount":4549,"customerCount":14722,"database":null,"dateMd":"03/17","dateYmd":"2016/03/17","scanCount":34348},{"DDate":"20160318","DDatefrom":null,"DDateto":null,"addCount":4894,"customerCount":15207,"database":null,"dateMd":"03/18","dateYmd":"2016/03/18","scanCount":35343},{"DDate":"20160319","DDatefrom":null,"DDateto":null,"addCount":4986,"customerCount":16398,"database":null,"dateMd":"03/19","dateYmd":"2016/03/19","scanCount":38168},{"DDate":"20160320","DDatefrom":null,"DDateto":null,"addCount":4058,"customerCount":14882,"database":null,"dateMd":"03/20","dateYmd":"2016/03/20","scanCount":34366},{"DDate":"20160321","DDatefrom":null,"DDateto":null,"addCount":4786,"customerCount":16433,"database":null,"dateMd":"03/21","dateYmd":"2016/03/21","scanCount":38266},{"DDate":"20160322","DDatefrom":null,"DDateto":null,"addCount":4521,"customerCount":15953,"database":null,"dateMd":"03/22","dateYmd":"2016/03/22","scanCount":37826},{"DDate":"20160323","DDatefrom":null,"DDateto":null,"addCount":2497,"customerCount":9361,"database":null,"dateMd":"03/23","dateYmd":"2016/03/23","scanCount":21911}]
     */

    private DataEntity data;
    /**
     * data : {"datato":"2016-03-23","datafrom":"2016-03-13","imgType":"1","data":null,"searchType":"0","msg":"成功","lstKpiUrl":"/image/output/openId/20160323/KPI002_20160323152808.gif","dataListDetail":[{"DDate":"20160313","DDatefrom":null,"DDateto":null,"addCount":3270,"customerCount":10441,"database":null,"dateMd":"03/13","dateYmd":"2016/03/13","scanCount":23633},{"DDate":"20160314","DDatefrom":null,"DDateto":null,"addCount":4303,"customerCount":12098,"database":null,"dateMd":"03/14","dateYmd":"2016/03/14","scanCount":25072},{"DDate":"20160315","DDatefrom":null,"DDateto":null,"addCount":4336,"customerCount":10405,"database":null,"dateMd":"03/15","dateYmd":"2016/03/15","scanCount":22204},{"DDate":"20160316","DDatefrom":null,"DDateto":null,"addCount":4539,"customerCount":13404,"database":null,"dateMd":"03/16","dateYmd":"2016/03/16","scanCount":30065},{"DDate":"20160317","DDatefrom":null,"DDateto":null,"addCount":4549,"customerCount":14722,"database":null,"dateMd":"03/17","dateYmd":"2016/03/17","scanCount":34348},{"DDate":"20160318","DDatefrom":null,"DDateto":null,"addCount":4894,"customerCount":15207,"database":null,"dateMd":"03/18","dateYmd":"2016/03/18","scanCount":35343},{"DDate":"20160319","DDatefrom":null,"DDateto":null,"addCount":4986,"customerCount":16398,"database":null,"dateMd":"03/19","dateYmd":"2016/03/19","scanCount":38168},{"DDate":"20160320","DDatefrom":null,"DDateto":null,"addCount":4058,"customerCount":14882,"database":null,"dateMd":"03/20","dateYmd":"2016/03/20","scanCount":34366},{"DDate":"20160321","DDatefrom":null,"DDateto":null,"addCount":4786,"customerCount":16433,"database":null,"dateMd":"03/21","dateYmd":"2016/03/21","scanCount":38266},{"DDate":"20160322","DDatefrom":null,"DDateto":null,"addCount":4521,"customerCount":15953,"database":null,"dateMd":"03/22","dateYmd":"2016/03/22","scanCount":37826},{"DDate":"20160323","DDatefrom":null,"DDateto":null,"addCount":2497,"customerCount":9361,"database":null,"dateMd":"03/23","dateYmd":"2016/03/23","scanCount":21911}]}
     * success : true
     */

    private boolean success;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataEntity getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class DataEntity {
        private String datato;
        private String datafrom;
        private String imgType;
        private Object data;
        private String searchType;
        private String msg;
        private String lstKpiUrl;
        /**
         * DDate : 20160313
         * DDatefrom : null
         * DDateto : null
         * addCount : 3270
         * customerCount : 10441
         * database : null
         * dateMd : 03/13
         * dateYmd : 2016/03/13
         * scanCount : 23633
         */

        private List<DataListDetailEntity> dataListDetail;

        public void setDatato(String datato) {
            this.datato = datato;
        }

        public void setDatafrom(String datafrom) {
            this.datafrom = datafrom;
        }

        public void setImgType(String imgType) {
            this.imgType = imgType;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setSearchType(String searchType) {
            this.searchType = searchType;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setLstKpiUrl(String lstKpiUrl) {
            this.lstKpiUrl = lstKpiUrl;
        }

        public void setDataListDetail(List<DataListDetailEntity> dataListDetail) {
            this.dataListDetail = dataListDetail;
        }

        public String getDatato() {
            return datato;
        }

        public String getDatafrom() {
            return datafrom;
        }

        public String getImgType() {
            return imgType;
        }

        public Object getData() {
            return data;
        }

        public String getSearchType() {
            return searchType;
        }

        public String getMsg() {
            return msg;
        }

        public String getLstKpiUrl() {
            return lstKpiUrl;
        }

        public List<DataListDetailEntity> getDataListDetail() {
            return dataListDetail;
        }

        public static class DataListDetailEntity {
            private String DDate;
            private Object DDatefrom;
            private Object DDateto;
            private int addCount;
            private int customerCount;
            private Object database;
            private String dateMd;
            private String dateYmd;
            private int scanCount;

            public void setDDate(String DDate) {
                this.DDate = DDate;
            }

            public void setDDatefrom(Object DDatefrom) {
                this.DDatefrom = DDatefrom;
            }

            public void setDDateto(Object DDateto) {
                this.DDateto = DDateto;
            }

            public void setAddCount(int addCount) {
                this.addCount = addCount;
            }

            public void setCustomerCount(int customerCount) {
                this.customerCount = customerCount;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public void setDateMd(String dateMd) {
                this.dateMd = dateMd;
            }

            public void setDateYmd(String dateYmd) {
                this.dateYmd = dateYmd;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public String getDDate() {
                return DDate;
            }

            public Object getDDatefrom() {
                return DDatefrom;
            }

            public Object getDDateto() {
                return DDateto;
            }

            public int getAddCount() {
                return addCount;
            }

            public int getCustomerCount() {
                return customerCount;
            }

            public Object getDatabase() {
                return database;
            }

            public String getDateMd() {
                return dateMd;
            }

            public String getDateYmd() {
                return dateYmd;
            }

            public int getScanCount() {
                return scanCount;
            }
        }
    }
}
