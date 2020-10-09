package com.github.sunrabbit123.JavaBot;

import java.awt.Color;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

	final static String token = "NzAwNjExMzg0OTk5NjczOTM2.XpldMg.EZ5a6LC0pdftpCdq2fH1ePyHl94";
	final static String prefix = "������";
	final static String URL = "https://open.neis.go.kr/hub/mealServiceDietInfo?"
			+ "KEY=bfa95730b1b84b07b2db733b2138d9aa&pIndex=1&pSize=100" + "&ATPT_OFCDC_SC_CODE=F10"
			+ "&SD_SCHUL_CODE=7380292";

	public static void main(String[] args) {
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		CheckTime ckt = new CheckTime(api);
		Thread th = new Thread(ckt);
		th.start();

		System.out.println("Logged in!");
		api.updateActivity("������������");

		api.addMessageCreateListener(ev -> {

			EmbedBuilder embed = new EmbedBuilder();// �Ӻ��� ����

			String msg = ev.getMessage().getContent();
			String userName = ev.getMessageAuthor().getName();
			TextChannel Ch = ev.getChannel();

			if (msg.startsWith(prefix)) {
				if (msg.contains("fkdlcb")) {
					Ch.sendMessage("������� �ѱ۹ۿ� �𸣴°ɿ�!");
				} else if (msg.contains("����")) {
					int RandomNum = (int) (Math.random() * 100);
					switch (RandomNum % 3) {
					case 1:
						Ch.sendMessage("�������� ����");
						break;
					case 2:
						Ch.sendMessage("�������� ������");
						break;
					case 3:
						Ch.sendMessage("������ �ҷ����� ���Դϴ�....\n�ε���....");
						break;
					}
				} else if (msg.contains("�ֻ���")) {
					int Rnum = (int) (Math.random() * 10) % 7;
					Ch.sendMessage("��������.... ");
					Ch.sendMessage("�Ǹ�����....");
					Ch.sendMessage(Rnum + "�Դϴ�..!");

				} else if (msg.contains("�޽�") || msg.contains("��ħ") || msg.contains("����") || msg.contains("����")
						|| msg.contains("�߽�") || msg.contains("����") || msg.contains("����")) {
					String Type = msg.contains("��ħ") || msg.contains("����") ? "����"
							: msg.contains("����") || msg.contains("�߽�") ? "�߽�"
									: msg.contains("����") || msg.contains("����") ? "����" : "�޽�";
					System.out.println(Type);
					Document doc = null;
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());

					int plus_date = 0;

					if (msg.contains("����")) {
						plus_date--;
					}
					if (msg.contains("����")) {
						plus_date++;
					}
					if (msg.contains("��") || msg.contains("��")) {
						plus_date += 2;
					}
					if (msg.contains("����")) {
						plus_date += 3;
					}
					if (msg.contains("������")) {
						plus_date += 7;
					}
					if (msg.contains("������")) {
						cal.add(Calendar.MONTH, 1);
					}
					cal.add(Calendar.DATE, plus_date);
					int year = cal.get(cal.YEAR);
					int month = cal.get(cal.MONTH) + 1;
					int date = cal.get(cal.DATE);

					String YMD = "&MLSV_YMD=";

					if (month < 10) {
						YMD += year + "0" + month;
					} else {
						YMD += year + month;
					}

					if (date < 10) {
						YMD += "0" + date;
					} else {
						YMD += date;
					}

					String URLS = URL + YMD;
					// URL ���

					try {
						doc = Jsoup.connect(URLS).get();
					} catch (IOException e) {
						e.printStackTrace();
					}
					String doctext = doc.text();
					doctext = doctext.replace(
							"�� : ������<br/>��ġ�� : ������<br/>���尡��(��ġ��) : ������<br/>�����(����) : ������(�ѿ�)<br/>�������� : ������<br/>�߰��� : ������<br/>�������� : ������<br/>����� ��������ǰ : ������<br/>�������� ��������ǰ : ������<br/>�߰��� ��������ǰ : ������<br/>�������� ����ǰ : ������<br/>���� : ������<br/>����� : ������<br/>��ġ : ������<br/>��¡�� : ������<br/>�ɰ� : ������<br/>������ : ������<br/>�� : ������ ",
							"");
					String mill = null;

					if (!Type.equals("�޽�")) {
						mill = doctext.substring(doctext.lastIndexOf(Type));
					} else {
						mill = doctext.substring(doctext.lastIndexOf("����"));
					}
					//����
					mill = mill.replaceAll("[0-9a-zA-Z.(g):/]", "");
					mill = mill.replaceAll("[*]", "");
					mill = mill.replace("���ֱ����ñ���û  ���ּ���Ʈ����̽��Ͱ����б�", "");
					mill = mill.replaceAll("ź��ȭ��  <>�ܹ���  <>����  <>��Ÿ��  <>Ƽ�ƹ�  <>�����ö��  <>��Ÿ��  <>Į��  <>ö��   ", "");
					mill = mill.replace("     ", "");
					mill = mill.replace("    ", "");

					String[] millList = mill.split("   ");
					if (!Type.equals("�޽�")) {
						mill = millList[1].replaceAll("<>", "\n");
						embed.addField(Type, mill);
					} else {
						try {
							for (int i = 0; i < 6; i += 2) {
								String type = millList[i];// ����, �߽�, ����
								mill = millList[i + 1].replaceAll("<>", "\n"); // �޴� ����

								embed.addField(type, mill, true);
							}
						} catch (Exception e) {
							System.out.println(e);
						}

					}

					embed.setTitle(year + "�� " + month + "�� " + date + "��").setColor(Color.RED)
							.setFooter(userName, ev.getMessageAuthor().getAvatar())
							.setTimestamp(new Date().toInstant());

					Ch.sendMessage(embed);
					System.out.println(Arrays.toString(millList));
					System.out.println(URLS);
				}

			}
		});
	};

}

class CheckTime implements Runnable {
	DiscordApi api;
	boolean checked = false;
	String targetTime = "16:33:00";

	public CheckTime(DiscordApi api) {
		this.api = api;
	}

	public void run() {
		while (true) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date time = new Date();
			String tm = format.format(time);

//            if (tm.equals(targetTime)) {
//                api.getTextChannelById("719449629963452449").get().sendMessage("�׽�Ʈ�ΰſ���! " + tm + "�� �Ǿ �޽����� ���¾��!");
//            }
		}
	}
}