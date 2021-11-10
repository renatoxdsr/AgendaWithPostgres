package dao;


import java.util.List;
import com.db4o.query.Query;
import java.lang.reflect.Field;

import modelo.Convidado;
import modelo.Participante;
import modelo.Reuniao;


public class DAOParticipante extends DAO<Participante>{
	public Participante read (Object chave) {
		String nome = (String) chave;
		
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("nome").constrain(nome);
		List<Participante> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;

		}
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PARTICIPANTE
	 * 
	 **********************************************************/
	
	public  List<Participante> readByCaracteres(String caracteres) {
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("nome").constrain(caracteres).like();
		List<Participante> result = q.execute(); 
		return result;
	}
	
	public Participante readByEmail(String e){
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("email").constrain(e);
		List<Participante> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);
	}
	
	public  List<Convidado> readAllByGuests(){
		Query q = manager.query();
		q.constrain(Convidado.class);
		q.descend("empresa");
		List<Convidado> resultados = q.execute();
		if(resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	public List<Participante> readAll(){
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("nome");
		List<Participante> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
}
