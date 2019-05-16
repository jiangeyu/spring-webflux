package think.in.java.chapter20;

import com.google.common.collect.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午8:05 2019/3/26
 * @desc
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {

        for (String className : args) {
            Class<?> cls = Class.forName(className);
            DbTable dbTable = cls.getAnnotation(DbTable.class);
            if (dbTable == null) {
                System.out.println("no dbTable annotation in dbTable");
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cls.getName().toLowerCase();
            }

            List<String> columnDefs = Lists.newArrayList();

            for (Field field : cls.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();

                if (annotations.length < 1) {
                    continue;//not table column
                }
                if (annotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) annotations[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }
                    columnDefs.add(columnName + " Int" +
                            getConstraints(sqlInteger.constraints()));
                }

                if (annotations[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) annotations[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " varchar" +"(" + sqlString.value() + ")" +
                            getConstraints(sqlString.constraints()));
                }


                StringBuilder createCommand = new StringBuilder();
                createCommand.append("create table " + tableName + "(");
                for (String columnDef : columnDefs) {
                     createCommand.append("\n" + columnDef + ",");
                }

                String tableCreate = createCommand.substring(0, createCommand.length()-1)
                        + ")";

                System.out.println(tableCreate);


            }
        }


    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " primary key";
        }
        if (con.unique()) {
            constraints += " unique";
        }

        return constraints;
    }
}
