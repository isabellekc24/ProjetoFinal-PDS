package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Projeto;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class JanelaAlterarDados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeProjeto;
	private JTextField txtDesc;
	private JLabel lblDataInicio;
	private JLabel lblDepart;
	private JLabel lblEquipePesq;
	private JLabel lblNewLabel_5;
	private JTextField txtDataInicio;
	private JTextField txtDataTermino;
	private JTextField txtDepart;
	private JTextField txtOrcam;
	private JLabel lblNomeCoord;
	private JLabel lblObjProjeto;
	private JLabel lblResultEsperados;
	private JTextField txtEquipePesq;
	private JTextField txtNomeCoord;
	private JTextField txtObjProjeto;
	private JTextField txtResultEsperados;
	private JLabel lblOrcam;
	private JLabel lblStatusProj;
	private JComboBox comboBox;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	public JanelaAlterarDados(Janela janelaPrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][69.00,grow][][44.00][64.00,grow][][][grow][][62.00]", "[][][][][][][][][][][][grow][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Nome Projeto");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		contentPane.add(lblNewLabel_1, "cell 5 0");
		
		txtNomeProjeto = new JTextField();
		txtNomeProjeto.setColumns(10);
		contentPane.add(txtNomeProjeto, "cell 0 1 5 1,growx");
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		contentPane.add(txtDesc, "cell 5 1 6 1,growx");
		
		lblDataInicio = new JLabel("Data Inicio");
		contentPane.add(lblDataInicio, "cell 0 2");
		
		lblNewLabel_5 = new JLabel("Data Término");
		contentPane.add(lblNewLabel_5, "cell 5 2");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		contentPane.add(txtDataInicio, "cell 0 3 5 1,growx");
		
		txtDataTermino = new JTextField();
		txtDataTermino.setColumns(10);
		contentPane.add(txtDataTermino, "cell 5 3 6 1,growx");
		
		lblDepart = new JLabel("Departamento");
		contentPane.add(lblDepart, "cell 0 4");
		
		lblOrcam = new JLabel("Orçamento");
		contentPane.add(lblOrcam, "cell 5 4");
		
		txtDepart = new JTextField();
		txtDepart.setColumns(10);
		contentPane.add(txtDepart, "cell 0 5 5 1,growx");
		
		txtOrcam = new JTextField();
		txtOrcam.setColumns(10);
		contentPane.add(txtOrcam, "cell 5 5 6 1,growx");
		
		lblEquipePesq = new JLabel("Equipe de Pesquisa");
		contentPane.add(lblEquipePesq, "cell 0 6");
		
		lblNomeCoord = new JLabel("Nome Coordenador");
		contentPane.add(lblNomeCoord, "cell 5 6");
		
		txtEquipePesq = new JTextField();
		txtEquipePesq.setColumns(10);
		contentPane.add(txtEquipePesq, "cell 0 7 5 1,growx");
		
		txtNomeCoord = new JTextField();
		txtNomeCoord.setColumns(10);
		contentPane.add(txtNomeCoord, "cell 5 7 6 1,growx");
		
		lblObjProjeto = new JLabel("Objetivo do Projeto");
		contentPane.add(lblObjProjeto, "cell 0 8");
		
		lblResultEsperados = new JLabel("Resultados Esperados");
		contentPane.add(lblResultEsperados, "cell 5 8");
		
		txtObjProjeto = new JTextField();
		txtObjProjeto.setColumns(10);
		contentPane.add(txtObjProjeto, "cell 0 9 5 1,growx");
		
		txtResultEsperados = new JTextField();
		txtResultEsperados.setColumns(10);
		contentPane.add(txtResultEsperados, "cell 5 9 6 1,growx");
		
		lblStatusProj = new JLabel("Status do Projeto");
		contentPane.add(lblStatusProj, "cell 0 10,alignx left");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Finalizado", "Andamento"}));
		contentPane.add(comboBox, "cell 2 10 3 1,growx");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto p = new Projeto();
				
				String nomeProjeto = txtNomeProjeto.getText();
                String descricao = txtDesc.getText();
                String dataInicio = txtDataInicio.getText();
                String dataTermino = txtDataTermino.getText();
                String depart = txtDepart.getText();
                String orcam = txtOrcam.getText();
                String equipePesq = txtEquipePesq.getText();
                String nomeCoord = txtNomeCoord.getText();
                String objetProjeto = txtObjProjeto.getText();
                String resultEsperados = txtResultEsperados.getText();
                String statusProjeto = (String) comboBox.getSelectedItem();

                // Conversão dos valores
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInicioLocalDate = LocalDate.parse(dataInicio, formatter);
                LocalDate dataTerminoLocalDate = LocalDate.parse(dataTermino, formatter);

                float orcamentoConvert = Float.parseFloat(orcam);
                
                //setando dentro do objeto
                p.setNomeProj(nomeProjeto);
                p.setDescProj(descricao);				
                p.setDataInicio(dataInicioLocalDate);
                p.setDataTermino(dataTerminoLocalDate);
                p.setDepartamento(depart);
                p.setOrcamento(orcamentoConvert);
                p.setEquipePesq(equipePesq);
                p.setNomeCoord(nomeCoord);
                p.setObjtProjeto(objetProjeto);
                p.setResultEsperado(resultEsperados);
                p.setStatusProj(statusProjeto);
				
				janelaPrincipal.definirDadosAlterado(p);
				dispose();
				
			}
		});
		
		
		contentPane.add(btnSalvar, "cell 8 13 2 1,growx");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelar, "cell 10 13,growx");
	}
	
	public void mostrarDados(Projeto projetoSelecionado) {
			txtNomeProjeto.setText(projetoSelecionado.getNomeProj());
			txtDesc.setText(projetoSelecionado.getDescProj());
		    txtDataInicio.setText(projetoSelecionado.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		    txtDataTermino.setText(projetoSelecionado.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		    txtDepart.setText(projetoSelecionado.getDepartamento());
		    txtOrcam.setText(String.valueOf(projetoSelecionado.getOrcamento()));
		    txtEquipePesq.setText(projetoSelecionado.getEquipePesq());
		    txtNomeCoord.setText(projetoSelecionado.getNomeCoord());
		    txtObjProjeto.setText(projetoSelecionado.getObjtProjeto());
		    txtResultEsperados.setText(projetoSelecionado.getResultEsperado());
		    comboBox.setSelectedItem(projetoSelecionado.getStatusProj());
	}

}
