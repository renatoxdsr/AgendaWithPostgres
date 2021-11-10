package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Reuniao {
	private int id; 		// será autoincrementado dentro do  metodo create() no DAOreuniao 
	private String datahora;
	private String assunto;
	private ArrayList <Participante> participantes = new ArrayList <Participante>();

	public Reuniao(Date dth, String assunto) 	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.datahora = format.format(dth);
		this.assunto = assunto;
	}

	public void adicionar(Participante p)	{
		participantes.add(p);
	}

	public void remover(Participante p)	{
		participantes.remove(p);
	}

	public Participante localizarParticipante(String nome)	{
		for(Participante p: participantes)	{
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}

	public ArrayList<Participante> getParticipantes() 	{
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) 	{
		this.participantes = participantes;
	}

	public int getTotalParticipantes()	{
		return participantes.size();
	}

	public int getId() 	{
		return id;
	}

	public void setId(int id) 	{
		this.id = id;
	}

	public Date getDatahora() throws ParseException 	{
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(this.datahora);
	}

	public void setDatahora(Date dth) 	{
		this.datahora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dth);
	}

	public String getAssunto() 	{
		return assunto;
	}

	public void setAssunto(String assunto) 	{
		this.assunto = assunto;
	}

	@Override
	public String toString() 	{
		String texto = "id: " + id + ", Horário: " + datahora + ", Assunto: " + assunto;

		texto +=  "\n Participantes:";
		for(Participante p: participantes) 
			texto += " " + p.getNome();

		return texto ;
	}
}





