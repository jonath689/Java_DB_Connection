import java.sql.SQLException;


public class Servicio extends SQLQuery
{
	public void verTodos()
	{
		try
		{
			this.conectar("127.0.0.1", "servicio", "root", "");
			this.consulta = this.conexion.prepareStatement("SELECT id,descripcion FROM servicio");
			this.datos = this.consulta.executeQuery();
			
			//while para varios datos, if para uno
			while(this.datos.next())
			{
				System.out.println("ID: " + this.datos.getInt("id") + ", DESCRIPCION: " + this.datos.getString("descripcion"));
			}
			
			this.desconectar();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("ClassNotFoundException: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
