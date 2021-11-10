package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Participante;
import modelo.Reuniao;

public class DAOReuniao extends DAO<Reuniao>{
	public Reuniao read (Object chave) {
		int id = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Reuniao.class);
		q.descend("id").constrain(id);
		List<Reuniao> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;

		}
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE REUNIAO
	 * 
	 **********************************************************/
	
	public List<Reuniao> readByDigitos(String digitos) {
		Query q = manager.query();
		q.constrain(Reuniao.class);
		q.descend("numero").constrain(digitos).like();
		List<Reuniao> result = q.execute(); 
		return result;
	}
	
	public List<Reuniao> readByData(String data) {
		
		Query q = manager.query();
		q.constrain(Reuniao.class);
		q.descend("datahora").constrain(data).like();
		List<Reuniao> result = q.execute(); 
		return result;
	}
	
	public List<Reuniao> readAll(){
		Query q = manager.query();
		q.constrain(Reuniao.class);
		q.descend("id");
		List<Reuniao> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	public void create(Reuniao obj){
		Reuniao r = (Reuniao) obj;
		int id = super.getMaxId();
		id++;
		r.setId(id);
		manager.store( r );
	}
}