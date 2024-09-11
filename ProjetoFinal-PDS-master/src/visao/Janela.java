package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ProjetoDAO;
import modelo.Projeto;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeProjeto;
	private JTextField txtDesc;
	private JTextField txtDataInicio;
	private JTextField txtDataTerm;
	private JTextField txtDepart;
	private JTextField txtOrcam;
	private JTextField txtEquipePesq;
	private JTextField txtNomeCoord;
	private JTextField txtObjProjeto;
	private JTextField txtResultEsperados;
	private JComboBox comboBox;
	private JLabel lblStatusProj;
	private JButton btdAdd;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnFechar;
	private JScrollPane scrollPane;
	private JTable table;
	private ArrayList<Projeto> listaProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
		
		ProjetoDAO pdao = new ProjetoDAO();
		listaProjeto = pdao.lerArquivo("dados.dat");
		//listaPessoas = new ArrayList<Pessoa>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][][][grow][][][grow][][]", "[][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Nome Projeto");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		contentPane.add(lblNewLabel_1, "cell 6 0");
		
		txtNomeProjeto = new JTextField();
		contentPane.add(txtNomeProjeto, "cell 0 1 5 1,growx");
		txtNomeProjeto.setColumns(10);
		
		txtDesc = new JTextField();
		contentPane.add(txtDesc, "cell 6 1 5 1,growx");
		txtDesc.setColumns(10);
		
		JLabel lbldataInicio = new JLabel("Data de Inicio (dd/MM/yyyy)");
		contentPane.add(lbldataInicio, "cell 0 2");
		
		JLabel lbldataTermino = new JLabel("Data Término (dd/MM/yyyy)");
		contentPane.add(lbldataTermino, "cell 6 2");
		
		txtDataInicio = new JTextField();
		contentPane.add(txtDataInicio, "cell 0 3 5 1,growx");
		txtDataInicio.setColumns(10);
		
		txtDataTerm = new JTextField();
		contentPane.add(txtDataTerm, "cell 6 3 5 1,growx");
		txtDataTerm.setColumns(10);
		
		JLabel lblDepart = new JLabel("Departamento");
		contentPane.add(lblDepart, "cell 0 4");
		
		JLabel lblOrcamento = new JLabel("Orçamento");
		contentPane.add(lblOrcamento, "cell 6 4");
		
		txtDepart = new JTextField();
		contentPane.add(txtDepart, "cell 0 5 5 1,growx");
		txtDepart.setColumns(10);
		
		txtOrcam = new JTextField();
		contentPane.add(txtOrcam, "cell 6 5 5 1,growx");
		txtOrcam.setColumns(10);
		
		JLabel lblEquipePesq = new JLabel("Equipe de Pesquisa");
		contentPane.add(lblEquipePesq, "cell 0 6");
		
		JLabel lblNomeCoord = new JLabel("Nome Coordenador");
		contentPane.add(lblNomeCoord, "cell 6 6");
		
		txtEquipePesq = new JTextField();
		contentPane.add(txtEquipePesq, "cell 0 7 5 1,growx");
		txtEquipePesq.setColumns(10);
		
		txtNomeCoord = new JTextField();
		contentPane.add(txtNomeCoord, "cell 6 7 5 1,growx");
		txtNomeCoord.setColumns(10);
		
		JLabel lblObjProjeto = new JLabel("Objetivos do Projeto");
		contentPane.add(lblObjProjeto, "cell 0 8");
		
		JLabel lblResultEsperados = new JLabel("Resultados Esperados");
		contentPane.add(lblResultEsperados, "cell 6 8");
		
		txtObjProjeto = new JTextField();
		contentPane.add(txtObjProjeto, "cell 0 9 5 1,growx");
		txtObjProjeto.setColumns(10);
		
		txtResultEsperados = new JTextField();
		contentPane.add(txtResultEsperados, "cell 6 9 5 1,growx");
		txtResultEsperados.setColumns(10);
		
		lblStatusProj = new JLabel("Status Projeto");
		contentPane.add(lblStatusProj, "cell 0 10,alignx left");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Finalizado", "Andamento"}));
		comboBox.setToolTipText("");
		contentPane.add(comboBox, "cell 1 10 4 1,growx");
		
		btdAdd = new JButton("Adicionar");
		btdAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pegando os valores
				Projeto novoProjeto = new Projeto();
				
                String nomeProjeto = txtNomeProjeto.getText();
                String descricao = txtDesc.getText();
                String dataInicio = txtDataInicio.getText();
                String dataTermino = txtDataTerm.getText();
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
                novoProjeto.setNomeProj(nomeProjeto);
                novoProjeto.setDescProj(descricao);				
                novoProjeto.setDataInicio(dataInicioLocalDate);
                novoProjeto.setDataTermino(dataTerminoLocalDate);
                novoProjeto.setDepartamento(depart);
                novoProjeto.setOrcamento(orcamentoConvert);
                novoProjeto.setEquipePesq(equipePesq);
                novoProjeto.setNomeCoord(nomeCoord);
                novoProjeto.setObjtProjeto(objetProjeto);
                novoProjeto.setResultEsperado(resultEsperados);
                novoProjeto.setStatusProj(statusProjeto);

                // Adiciona o projeto à lista e atualiza a tabela
                listaProjeto.add(novoProjeto);

                atualizarTabela();
                limparCampos();
				
			}

			
		});
		contentPane.add(btdAdd, "cell 0 11");
		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSelecionada = table.getSelectedRow();
				listaProjeto.remove(posicaoSelecionada);
				atualizarTabela();
			}
		});
		contentPane.add(btnExcluir, "cell 3 11");
		
		Janela estaJanela = this;
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSelecionada = table.getSelectedRow();
				Projeto projetoSelecionado = listaProjeto.get(posicaoSelecionada);
				JanelaAlterarDados novaJanela = new JanelaAlterarDados(estaJanela);
				novaJanela.mostrarDados(projetoSelecionado);
				novaJanela.setVisible(true);
			}
		});
		contentPane.add(btnEditar, "cell 6 11");
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pdao.escreverArquivo(listaProjeto, "dados.dat");
				dispose();
				}
		});
		contentPane.add(btnFechar, "cell 10 11");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 12 11 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do Projeto", "Data Inicio", "Status Projeto"
			}
		));
		scrollPane.setViewportView(table);
		atualizarTabela();

	}
	
	 private void atualizarTabela() {
	        DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
	        modeloTabela.setRowCount(0); // Limpa a tabela

	        for (Projeto p : listaProjeto) {
	            modeloTabela.addRow(new Object[] {
	                p.getNomeProj(),
	                p.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	                p.getStatusProj()
	            });
	        }
	    }

	    private void limparCampos() {
	        txtNomeProjeto.setText("");
	        txtDesc.setText("");
	        txtDataInicio.setText("");
	        txtDataTerm.setText("");
	        txtDepart.setText("");
	        txtOrcam.setText("");
	        txtEquipePesq.setText("");
	        txtNomeCoord.setText("");
	        txtObjProjeto.setText("");
	        txtResultEsperados.setText("");
	        comboBox.setSelectedIndex(0); // Resetar seleção para o primeiro item
	    }
	    
	    public void definirDadosAlterado(Projeto p) {
	    	
			int posicao = table.getSelectedRow();
			
			listaProjeto.get(posicao).setDataInicio(p.getDataInicio());
			listaProjeto.get(posicao).setNomeProj(p.getNomeProj());
			listaProjeto.get(posicao).setDescProj(p.getDescProj());
			listaProjeto.get(posicao).setDepartamento(p.getDepartamento());
			listaProjeto.get(posicao).setEquipePesq(p.getEquipePesq());
			listaProjeto.get(posicao).setNomeCoord(p.getNomeCoord());
			listaProjeto.get(posicao).setObjtProjeto(p.getObjtProjeto());
			listaProjeto.get(posicao).setOrcamento(p.getOrcamento());
			listaProjeto.get(posicao).setResultEsperado(p.getResultEsperado());
			listaProjeto.get(posicao).setDataTermino(p.getDataTermino());
			listaProjeto.get(posicao).setStatusProj(p.getStatusProj());
			
			atualizarTabela();
			
		}
	

}
