import java.sql.*;

public class SQLQuery
{
	// Maneja la conexion
	protected Connection conexion;
	
	//No se crean en tiempo de ejecucion, evitan inyeccion de SQL
	//Siempre que hay interaccion usuario-consulta (ingreso de datos)
	protected PreparedStatement consulta;
	
	protected ResultSet datos;
	
	public void conectar(String servidor, String bd, String usuario, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		this.conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + bd, usuario, password);
	}
	
	public void desconectar() throws SQLException
	{
		this.conexion.close();
		this.consulta.close();
	}
	
	public void desconectar(ResultSet rs) throws SQLException
	{
		this.desconectar();
		rs.close();
	}
}