 Appearance createAppearance(){
		    Appearance ap = new Appearance();
		    BufferedImage[] bi = new BufferedImage[6];
		    for (int i = 0; i < 6; i++) {
		        bi[i] = new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB);
		    }
		    Graphics2D g2 = (Graphics2D)bi[0].getGraphics();
		    g2.setColor(Color.lightGray);
		    g2.fillRect(0, 0, 128, 128);
		    
		    //ImageComponent2D[] image = new ImageComponent2D[6];
		    //for (int i = 0; i < 6; i++) {
		       // image[i] = new ImageComponent2D(ImageComponent2D.FORMAT_RGBA, bi[i]);
		        //}
		    return ap;
	  }
