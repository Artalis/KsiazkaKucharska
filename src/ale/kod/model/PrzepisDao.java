package ale.kod.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrzepisDao {
    private static final String URL ="jdbc:mysql://localhost:3306/CookBook";
    private static final String USER ="root";
    private static String PASS ="Artalis13";
    private Connection connection;


    public PrzepisDao() {

            try {
                connection = ConnectionProvider.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public void save(Przepis przepis){
        final String sql = "insert into cookbook(name,kind,time,url,text) values (?,?,?,?,?);";
        try{
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1,przepis.getName());
            prepStmt.setString(2,przepis.getRodzaj());
            prepStmt.setInt(3,przepis.getCzas());
            prepStmt.setString(4,przepis.getUrl());
            prepStmt.setString(5,przepis.getTresc());
            prepStmt.executeUpdate();
            System.out.println("Przepis saved");

        }catch (SQLException e){
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public List<Przepis> readAll() {
        final String sql = "select ID,name,kind,time,url,text from cookbook";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);
        } catch (SQLException e) {
            System.out.println("Could not get books");
        }
        return null;
    }
    public List<Przepis> readAllBy(String what,String how) { //how -ASC|DESC
        String sql = "select ID,name,kind,time,url,text from cookbook order by ";
        String s=what+" "+how;
        sql=sql+s;
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Przepis> read(String rodzaj){
        final String sql = "select ID,name,kind,time,url,text from cookbook where kind=?";
        try{
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, rodzaj);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);

        }catch (SQLException e) {
            System.out.println("Could not get przepis");
        }
        return null;
    }

    public List<Przepis> readBy(String rodzaj,String what,String how){
        String sql = "select ID,name,kind,time,url,text from cookbook where kind=? order by ";
        String s=what+" "+how;
        sql=sql+s;
        try{
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, rodzaj);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);

        }catch (SQLException e) {
        }
        return null;
    }

    private List<Przepis> prepareList( ResultSet result) throws SQLException {
        List<Przepis> przepisy=new ArrayList<>();
        while (result.next()) {
            Przepis przepis = new Przepis();
            przepis.setID(result.getInt("ID"));
            przepis.setName(result.getString("name"));
            przepis.setRodzaj(result.getString("kind"));
            przepis.setCzas(result.getInt("time"));
            przepis.setUrl(result.getString("url"));
            przepis.setTresc(result.getString("text"));
            przepisy.add(przepis);
        }
        return przepisy;
    }


    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
