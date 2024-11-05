package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.ReportingLogic;
import Entity.InjuredInReport;
import Entity.Report;

public class ShowReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table_3;
	private JScrollPane scrollPane_3;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	DefaultTableModel model3;

	public ShowReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 27, 586, 100);
		contentPane.add(scrollPane_2);

		table = new JTable();
		model = new DefaultTableModel();

		Object[] DataInRows = new Object[5];
		Object[] culomn = { "ReportNumber", "InjuredNumber", "location", "situation", "time" };
		scrollPane_2.setViewportView(table);

		model.setColumnIdentifiers(culomn);
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 137, 586, 100);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		model1 = new DefaultTableModel();

		Object[] DataInRows1 = new Object[5];
		Object[] culomn1 = { "ReportNumber", "InjuredNumber", "location", "situation", "time" };
		scrollPane.setViewportView(table_1);
		model1.setColumnIdentifiers(culomn1);
		table_1.setModel(model1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 246, 587, 100);
		contentPane.add(scrollPane_1);

		table_2 = new JTable();
		model2 = new DefaultTableModel();

		Object[] DataInRows2 = new Object[5];
		Object[] culomn2 = { "ReportNumber", "InjuredNumber", "location", "situation", "time" };
		scrollPane_1.setViewportView(table_2);
		model2.setColumnIdentifiers(culomn2);
		table_2.setModel(model2);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(30, 358, 586, 100);
		contentPane.add(scrollPane_3);

		table_3 = new JTable();
		model3 = new DefaultTableModel();

		Object[] DataInRows3 = new Object[5];
		Object[] culomn3 = { "ReportNumber", "InjuredNumber", "location", "situation", "time" };
		scrollPane_3.setViewportView(table_3);
		model3.setColumnIdentifiers(culomn3);
		table_3.setModel(model3);

		btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Location, Situation, privateNumberOfReport, privateNumberOfInjured, hour, minute;
				Date date = new Date();
				ArrayList<Report> tmpReports = new ArrayList<Report>();
				ArrayList<InjuredInReport> tmpInjuredInReports = new ArrayList<InjuredInReport>();
				tmpInjuredInReports = ReportingLogic.getInstance().getInjuredInReports();
				System.out.println(tmpInjuredInReports);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String todayDate = dateFormat.format(date);
				for (Report r : ReportingLogic.getInstance().getReports()) {
					if (r.getDateExitOfTheInjured().equals(todayDate)) {
						tmpReports.add(r);
					}
				}
				
				Collections.sort(tmpReports, new Comparator<Report>() {

					@Override
					public int compare(Report o1, Report o2) {
						// TODO Auto-generated method stub
						return o1.calculate() - o2.calculate();
					}
				});
				System.out.println(tmpReports);

				for (Report report : tmpReports) {
					for (InjuredInReport injuredInReport : tmpInjuredInReports) {
						if (injuredInReport.getPrivateNumberOfReport().equals(report.getPrivateNUmber())) {
							if (injuredInReport.getSituation().equals("easy")) {
								DataInRows[0] = injuredInReport.getPrivateNumberOfReport();
								DataInRows[1] = injuredInReport.getPrivateNumberOfInjured();
								DataInRows[2] = injuredInReport.getLocation();
								DataInRows[3] = injuredInReport.getSituation();
								DataInRows[4] = report.getHour() + " : " + report.getMinute();
								model.addRow(DataInRows);
							}
							if (injuredInReport.getSituation().equals("medium")) {
								DataInRows1[0] = injuredInReport.getPrivateNumberOfReport();
								DataInRows1[1] = injuredInReport.getPrivateNumberOfInjured();
								DataInRows1[2] = injuredInReport.getLocation();
								DataInRows1[3] = injuredInReport.getSituation();
								DataInRows1[4] = report.getHour() + " : " + report.getMinute();
								model1.addRow(DataInRows1);
							}
							if (injuredInReport.getSituation().equals("hard")) {
								DataInRows2[0] = injuredInReport.getPrivateNumberOfReport();
								DataInRows2[1] = injuredInReport.getPrivateNumberOfInjured();
								DataInRows2[2] = injuredInReport.getLocation();
								DataInRows2[3] = injuredInReport.getSituation();
								DataInRows2[4] = report.getHour() + " : " + report.getMinute();
								model2.addRow(DataInRows2);
							}
							if (injuredInReport.getSituation().equals("die")) {
								DataInRows3[0] = injuredInReport.getPrivateNumberOfReport();
								DataInRows3[1] = injuredInReport.getPrivateNumberOfInjured();
								DataInRows3[2] = injuredInReport.getLocation();
								DataInRows3[3] = injuredInReport.getSituation();
								DataInRows3[4] = report.getHour() + " : " + report.getMinute();
								model3.addRow(DataInRows3);
							}
						}
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 501, 111, 52);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Return to Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomePage().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(169, 501, 204, 52);
		contentPane.add(btnNewButton_1);

	}
}
