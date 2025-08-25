package builder;

import java.util.LinkedHashMap;
import java.util.Map;

public class SQL {

    public static selectBuilder select(String ...cloums){
        return new selectBuilder(cloums);
    }
    public static updateBuilder update(String table) {
        return new updateBuilder(table);
    }
    public static class selectBuilder {
       private String [] cloums;

       private String table;

       private String where;

       public selectBuilder(String[] cloums) {
              this.cloums = cloums;
       }


       public selectBuilder from(String table) {
                this.table = table;
                return this;
       }
       public selectBuilder where(String where) {
                this.where = where;
                return this;
       }
       public String build() {
           StringBuilder sql = new StringBuilder("SELECT ");
           if (cloums == null || cloums.length == 0) {
               sql.append("*");
           } else {
               sql.append(String.join(", ", cloums));
           }
           if (table == null) {
               throw new IllegalArgumentException("table不能为空");
           }
           sql.append(" FROM ").append(table);
           if (where != null && !where.isEmpty()) {
               sql.append(" WHERE ").append(where);
           }
           System.out.println(sql.toString());
           return sql.toString();
       }
    }

    public static class updateBuilder {
        private String table;
        private Map<String,Object> set = new LinkedHashMap<>();
        private String where;

        public updateBuilder(String table) {
            this.table = table;
        }

        public updateBuilder set(String name,Object value) {
            set.put(name, value);
            return this;
        }

        public updateBuilder where(String where) {
            this.where = where;
            return this;
        }

        public String build() {
            if (table == null || table.isEmpty()) {
                throw new IllegalArgumentException("table不能为空");
            }
            if (set == null || set.isEmpty()) {
                throw new IllegalArgumentException("set不能为空");
            }
            StringBuilder sql = new StringBuilder("UPDATE ");
            sql.append(table).append(" SET ");
            set.forEach((k,v)->{
                sql.append(k).append(" = ");
                if (v instanceof String) {
                    sql.append("'").append(v).append("'");
                } else {
                    sql.append(v);
                }
                sql.append(", ");
            });
            if (where != null && !where.isEmpty()) {
                sql.append(" WHERE ").append(where);
            }
            System.out.println(sql.toString());
            return sql.toString();
        }
    }
}
