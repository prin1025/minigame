package minigame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {



	private JLayeredPane contentPane;
	public int turncount=0,now=0;

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 408);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int i,c;

		final int ORIGIN = 12;
		final int TILESIZE = 50;
		int x[]=new int[10];
		int y[]=new int[10];
		int hp[]=new int[10];
		int tilecondition[][]=new int[5][6];
		int target[]=new int[10];
		for(i=0;i<5;i++) {
			for(c=0;c<6;c++) {
			tilecondition[i][c]=0;
			}
		}
		tilecondition[0][5]=1;
		tilecondition[1][4]=2;
		tilecondition[2][5]=3;
		tilecondition[3][4]=4;
		tilecondition[4][5]=5;
		tilecondition[0][0]=6;
		tilecondition[1][1]=7;
		tilecondition[2][0]=8;
		tilecondition[3][1]=9;
		tilecondition[4][0]=10;
		x[0]=0;x[1]=1;x[2]=2;x[3]=3;x[4]=4;x[5]=0;x[6]=1;x[7]=2;x[8]=3;x[9]=4;y[0]=5;y[1]=4;y[2]=5;y[3]=4;y[4]=5;y[5]=0;y[6]=1;y[7]=0;y[8]=1;y[9]=0;


		ImageIcon tile = new ImageIcon("img/tile.png");
		ImageIcon range = new ImageIcon("img/tile2.png");
		ImageIcon icon1 = new ImageIcon("img/icon1.png");
		ImageIcon icon2 = new ImageIcon("img/icon2.png");
		ImageIcon arrow = new ImageIcon("img/arrow.png");
		JLabel label[] = new JLabel[52];
		JButton button[]=new JButton[30];



		for(i=0;i<10;i++) {
			hp[i]=3;
			target[i]=0;
			}
		for(i=1;i<11;i++) {
			label[i] = new JLabel("HP:3");
			}
		for(i=11;i<16;i++) {
		label[i] = new JLabel(icon1);
		}
		for(i=16;i<21;i++) {
		label[i] = new JLabel(icon2);
		}
		for(i=21;i<51;i++) {
		label[i] = new JLabel(tile);
		}
		for(i=0;i<30;i++) {
		button[i] = new JButton(range);
		}
		label[52] = new JLabel("攻撃1:範囲1,威力2    攻撃2:範囲2,威力1");
		contentPane.add(label[52]);

		for(i=0;i<30;i++) {
		label[i+21].setBounds(i%5*TILESIZE+ORIGIN, (i/5)*TILESIZE+ORIGIN, 47, 47);
		}


		label[1].setBounds(ORIGIN+10,TILESIZE*5+ORIGIN+1, 45, 45);
		label[2].setBounds(TILESIZE+ORIGIN+10, TILESIZE*4+ORIGIN+1, 45, 45);
		label[3].setBounds(TILESIZE*2+ORIGIN+10,TILESIZE*5+ORIGIN+1, 45, 45);
		label[4].setBounds(TILESIZE*3+ORIGIN+10, TILESIZE*4+ORIGIN+1, 45, 45);
		label[5].setBounds(TILESIZE*4+ORIGIN+10, TILESIZE*5+ORIGIN+1, 45, 45);
		label[6].setBounds(ORIGIN+10, ORIGIN+1, 45, 45);
		label[7].setBounds(TILESIZE+ORIGIN+10, TILESIZE+ORIGIN+1, 45, 45);
		label[8].setBounds(TILESIZE*2+ORIGIN+10,ORIGIN+1, 45, 45);
		label[9].setBounds(TILESIZE*3+ORIGIN+10, TILESIZE+ORIGIN+1, 45, 45);
		label[10].setBounds(TILESIZE*4+ORIGIN+10, ORIGIN+1, 45, 45);
		label[11].setBounds(ORIGIN+1, TILESIZE*5+ORIGIN+1, 45, 45);
		label[12].setBounds(TILESIZE+ORIGIN+1, TILESIZE*4+ORIGIN+1, 45, 45);
		label[13].setBounds(TILESIZE*2+ORIGIN+1,TILESIZE*5+ORIGIN+1, 45, 45);
		label[14].setBounds(TILESIZE*3+ORIGIN+1, TILESIZE*4+ORIGIN+1, 45, 45);
		label[15].setBounds(TILESIZE*4+ORIGIN+1, TILESIZE*5+ORIGIN+1, 45, 45);
		label[16].setBounds(ORIGIN+1, ORIGIN+1, 45, 45);
		label[17].setBounds(TILESIZE+ORIGIN+1, TILESIZE+ORIGIN+1, 45, 45);
		label[18].setBounds(TILESIZE*2+ORIGIN+1,ORIGIN+1, 45, 45);
		label[19].setBounds(TILESIZE*3+ORIGIN+1, TILESIZE+ORIGIN+1, 45, 45);
		label[20].setBounds(TILESIZE*4+ORIGIN+1, ORIGIN+1, 45, 45);
		label[52].setBounds(10, 350, 300, 45);
		for(i=1;i<51;i++) {
		contentPane.add(label[i]);
		}
		for(i=1;i<11;i++) {
			contentPane.setLayer(label[i] , 4);
			}
		for(i=11;i<21;i++) {
		contentPane.setLayer(label[i] , 3);
		}
		for(i=21;i<51;i++) {
		contentPane.setLayer(label[i] , 1);
		}

		label[0] = new JLabel(arrow);

		JButton btnNewButton = new JButton("攻撃1");
		btnNewButton.setBounds(12, 334, 91, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("攻撃2");
		btnNewButton_1.setBounds(115, 334, 91, 21);
		contentPane.add(btnNewButton_1);


		JButton btnNewButton_2 = new JButton("待機");
		btnNewButton_2.setBounds(218, 334, 91, 21);
		contentPane.add(btnNewButton_2);

		button[0]=turnend(label,button,x,y,0,tilecondition,target,hp);





button[0].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		label[11+now].setBounds((x[now]+1)*TILESIZE+ORIGIN+1, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		label[1+now].setBounds((x[now]+1)*TILESIZE+ORIGIN+10, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		x[now]+=1;
		tilecondition[x[now]][y[now]]=now+1;
		label[0].setBounds(x[now]*TILESIZE+TILESIZE/2+ORIGIN-12, y[now]*TILESIZE+ORIGIN-15, 20, 15);
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});


button[1].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		label[11+now].setBounds((x[now]-1)*TILESIZE+ORIGIN+1, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		label[1+now].setBounds((x[now]-1)*TILESIZE+ORIGIN+10, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		x[now]-=1;
		tilecondition[x[now]][y[now]]=now+1;
		label[0].setBounds(x[now]*TILESIZE+TILESIZE/2+ORIGIN-12, y[now]*TILESIZE+ORIGIN-15, 20, 15);
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});

button[2].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		label[11+now].setBounds(x[now]*TILESIZE+ORIGIN+1, (y[now]+1)*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds(x[now]*TILESIZE+ORIGIN+10,(y[now]+1)*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		y[now]+=1;
		tilecondition[x[now]][y[now]]=now+1;
		label[0].setBounds(x[now]*TILESIZE+TILESIZE/2+ORIGIN-12, y[now]*TILESIZE+ORIGIN-15, 20, 15);
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});

button[3].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		label[11+now].setBounds(x[now]*TILESIZE+ORIGIN+1, (y[now]-1)*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds(x[now]*TILESIZE+ORIGIN+10,(y[now]-1)*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		y[now]-=1;
		tilecondition[x[now]][y[now]]=now+1;
		label[0].setBounds(x[now]*TILESIZE+TILESIZE/2+ORIGIN-12, y[now]*TILESIZE+ORIGIN-15, 20, 15);
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});




btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=5;i<10;i++) {
			if(x[now]+1==x[i]&&y[now]==y[i]) target[i]=1;
			if(x[now]-1==x[i]&&y[now]==y[i]) target[i]=1;
			if(x[now]==x[i]&&y[now]+1==y[i]) target[i]=1;
			if(x[now]==x[i]&&y[now]-1==y[i]) target[i]=1;
		}
			damage(target,hp,label,tilecondition,x,y);
			turncount++;
			if(turncount>9)turncount=0;
			for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=5;i<10;i++) {
			if(x[now]+3>x[i]&&x[now]-3<x[i]&&y[now]==y[i]) target[i]=2;
			if(x[now]+2>x[i]&&x[now]-2<x[i]&&y[now]+2>y[i]&&y[now]-2<y[i]) target[i]=2;
			if(x[now]==x[i]&&y[now]+3>y[i]&&y[now]-3<y[i]) target[i]=2;
		}
		damage(target,hp,label,tilecondition,x,y);
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});

btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		turncount++;
		if(turncount>9)turncount=0;
		for(int i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	}
});


	}

	public JButton turnend(JLabel label[],JButton button[], int x[],int y[],int a,int tilecondition[][],int target[],int hp[]){
		final int ORIGIN = 12;
		final int TILESIZE = 50;
		int diecount=0;

		for(int i=0;i<4;i++) {
			contentPane.remove(button[i]);
		}
		contentPane.repaint();
		for(int i=0;i<5;i++) {
			if(hp[i]==0) diecount++;
		}
		if(diecount==5) {
			label[51] = new JLabel("You lose");
			label[51].setBounds(300,10, 60, 45);
			contentPane.add(label[51]);
		}
		diecount=0;
		for(int i=5;i<10;i++) {
			if(hp[i]==0) diecount++;
		}
		if(diecount==5) {
			label[51] = new JLabel("You win!");
			label[51].setBounds(300,10, 60, 45);
			contentPane.add(label[51]);
		}
		if(hp[now]==0) {
			turncount++;
			if(turncount>9)turncount=0;
		}
		nowturn();

		label[0].setBounds(x[now]*TILESIZE+TILESIZE/2+ORIGIN-12, y[now]*TILESIZE+ORIGIN-15, 20, 15);
		contentPane.add(label[0]);
		contentPane.setLayer(label[0] , 4);
if(now<5) {
		if((x[now]+1<5)&&tilecondition[x[now]+1][y[now]]==0) {
			button[0].setBounds((x[now]+1)*TILESIZE+ORIGIN, y[now]*TILESIZE+ORIGIN, 47, 47);
			contentPane.add(button[0]);
			contentPane.setLayer(button[0] , 2);
		}
		if((x[now]-1>-1)&&tilecondition[x[now]-1][y[now]]==0) {
			button[1].setBounds((x[now]-1)*TILESIZE+ORIGIN, y[now]*TILESIZE+ORIGIN, 47, 47);
			contentPane.add(button[1]);
			contentPane.setLayer(button[1] , 2);
		}
		if((y[now]+1)<6&&tilecondition[x[now]][y[now]+1]==0) {
			button[2].setBounds(x[now]*TILESIZE+ORIGIN, (y[now]+1)*TILESIZE+ORIGIN, 47, 47);
			contentPane.add(button[2]);
			contentPane.setLayer(button[2] , 2);
		}
		if((y[now]-1>-1)&&tilecondition[x[now]][y[now]-1]==0) {
			button[3].setBounds(x[now]*TILESIZE+ORIGIN, (y[now]-1)*TILESIZE+ORIGIN, 47, 47);
			contentPane.add(button[3]);
			contentPane.setLayer(button[3] , 2);
		}
}else {enemy(target,hp,label,tilecondition,x,y,button);}
return button[a];
	}

	public void damage(int target[],int hp[], JLabel label[],int tilecondition[][], int x[],int y[]) {
		int a,b;
		if(now<5) {a=5;b=10;}else {a=0;b=5;}
	for(int i=a;i<b;i++) {
		if(target[i]>0) {
			if(target[i]==1) hp[i]-=2;
			if(target[i]==2) hp[i]--;
			contentPane.remove(label[i+1]);
			String s=Integer.toString(hp[i]);
			s="HP:"+s;
			label[i+1].setText(s);
			contentPane.add(label[i+1]);
			contentPane.repaint();
			if(hp[i]<1) {
				contentPane.remove(label[i+1]);
				contentPane.remove(label[i+11]);
				contentPane.repaint();
				tilecondition[x[i]][y[i]]=0;
				hp[i]=0;
			}
			target[i]=0;
		}

	}
	}
	public void nowturn() {
		if(turncount==0) now=0;
		if(turncount==1) now=5;
		if(turncount==2) now=1;
		if(turncount==3) now=6;
		if(turncount==4) now=2;
		if(turncount==5) now=7;
		if(turncount==6) now=3;
		if(turncount==7) now=8;
		if(turncount==8) now=4;
		if(turncount==9) now=9;
	}

public void enemy(int target[],int hp[], JLabel label[],int tilecondition[][], int x[],int y[],JButton button[]) {
	int i,attack=0,movetarget;
	int x1[] = new int[5];
	int y1[] = new int[5];
	int active[]= new int[5];
	final int ORIGIN = 12;
	final int TILESIZE = 50;
	for(i=0;i<5;i++) {
		if(hp[i]>0) {
		if(x[now]+1==x[i]&&y[now]==y[i]) {target[i]=1;attack=1;}
		if(x[now]-1==x[i]&&y[now]==y[i]) {target[i]=1;attack=1;}
		if(x[now]==x[i]&&y[now]+1==y[i]) {target[i]=1;attack=1;}
		if(x[now]==x[i]&&y[now]-1==y[i]) {target[i]=1;attack=1;}
		if(x[now]+3>x[i]&&x[now]-3<x[i]&&y[now]==y[i]) {target[i]=2;attack=1;}
		if(x[now]+2>x[i]&&x[now]-2<x[i]&&y[now]+2>y[i]&&y[now]-2<y[i]) {target[i]=2;attack=1;}
		if(x[now]==x[i]&&y[now]+3>y[i]&&y[now]-3<y[i]) {target[i]=2;attack=1;}
		}
	}

	if(attack==1) {
		damage(target,hp,label,tilecondition,x,y);
		turncount++;
		if(turncount>9)turncount=0;
		nowturn();
		attack=0;
		for(i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
		return;
	}
	for(i=0;i<5;i++) active[i]=0;
	for(i=0;i<5;i++) {x1[i]=x[i];y1[i]=y[i];}
	for(i=0;i<5;i++) {if(hp[i]>0) active[i]=1;}
	movetarget=distance_min(x1,y1,5,x[now],y[now],active);
	for(i=0;i<4;i++) {x1[i]=x[now];y1[i]=y[now];}
	x1[0]++;x1[1]--;y1[2]++;y1[3]--;
	for(i=0;i<4;i++) active[i]=0;
	if(x[now]+1<5) active[0]=1;
	if(x[now]-1>-1) active[1]=1;
	if(y[now]+1<6) active[2]=1;
	if(y[now]-1>-1) active[3]=1;
	movetarget=distance_min(x1,y1,4,x[movetarget],y[movetarget],active);
	if(movetarget==0) {
		label[11+now].setBounds((x[now]+1)*TILESIZE+ORIGIN+1, y[now]*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds((x[now]+1)*TILESIZE+ORIGIN+10, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		x[now]+=1;
		tilecondition[x[now]][y[now]]=now+1;
	}
	if(movetarget==1) {
		label[11+now].setBounds((x[now]-1)*TILESIZE+ORIGIN+1, y[now]*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds((x[now]-1)*TILESIZE+ORIGIN+10, y[now]*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		x[now]-=1;
		tilecondition[x[now]][y[now]]=now+1;
	}
	if(movetarget==2) {
		label[11+now].setBounds(x[now]*TILESIZE+ORIGIN+1, (y[now]+1)*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds(x[now]*TILESIZE+ORIGIN+10,(y[now]+1)*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		y[now]+=1;
		tilecondition[x[now]][y[now]]=now+1;
	}
	if(movetarget==3) {
		label[11+now].setBounds(x[now]*TILESIZE+ORIGIN+1, (y[now]-1)*TILESIZE+ORIGIN+1, 47, 47);
		label[1+now].setBounds(x[now]*TILESIZE+ORIGIN+10,(y[now]-1)*TILESIZE+ORIGIN+1, 45, 45);
		tilecondition[x[now]][y[now]]=0;
		y[now]-=1;
		tilecondition[x[now]][y[now]]=now+1;
	}
	turncount++;
	if(turncount>9)turncount=0;
	nowturn();
	for(i=0;i<4;i++) button[i]=turnend(label,button,x,y,i,tilecondition,target,hp);
	return;
}

public int distance_min(int x[],int y[],int a,int pointx,int pointy,int active[]) {
	int distance,distance_min,movetarget=0;
	distance_min=42;
	for(int i=0;i<a;i++) {
		if(active[i]==1) {
			distance=(pointx-x[i])*(pointx-x[i])+(pointy-y[i])*(pointy-y[i]);
			if(distance<distance_min) {
				distance_min=distance;
				movetarget=i;
			}
		}
	}
	return movetarget;
}

}
