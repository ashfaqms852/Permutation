
package permutation.view;

import permutation.controller.PermutationController;


public class GetInput extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5510596421539785614L;
	private static GetInput getInput;
	
	public static GetInput getInstance(){
		if(getInput==null)
			getInput = new GetInput();
		return getInput;
	}
	
    private GetInput() {
        initComponents();
    }

    
    //@SuppressWarnings("unchecked")
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lexOrder = new javax.swing.JButton();
        factorialOrder = new javax.swing.JButton();
        heapOrder = new javax.swing.JButton();
        sjtOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Permutation");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter a number,");

        lexOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lexOrder.setText("Lexicographic Order");
        lexOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lexOrderActionPerformed(evt);
            }
        });

        factorialOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        factorialOrder.setText("Factorial Order");
        factorialOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorialOrderActionPerformed(evt);
            }
        });

        heapOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        heapOrder.setText("Heap ");
        heapOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heapOrderActionPerformed(evt);
            }
        });

        sjtOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sjtOrder.setText("Steinhaus Johnson Trotter");
        sjtOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sjtOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lexOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(heapOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(factorialOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sjtOrder))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lexOrder)
                    .addComponent(factorialOrder))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heapOrder)
                    .addComponent(sjtOrder))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lexOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lexOrderActionPerformed
        // TODO add your handling code here:
    	PermutationController.doLex();
    }//GEN-LAST:event_lexOrderActionPerformed

    private void factorialOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factorialOrderActionPerformed
        // TODO add your handling code here:
    	PermutationController.doFactorialPermute();
    }//GEN-LAST:event_factorialOrderActionPerformed

    private void heapOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heapOrderActionPerformed
        // TODO add your handling code here:
    	PermutationController.doHeapPermute();
    }//GEN-LAST:event_heapOrderActionPerformed

    private void sjtOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sjtOrderActionPerformed
        // TODO add your handling code here:
    	PermutationController.doSteinhausJohnsonTrotter();
    }//GEN-LAST:event_sjtOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void init() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GetInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetInput().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton factorialOrder;
    private javax.swing.JButton heapOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lexOrder;
    private javax.swing.JButton sjtOrder;
    // End of variables declaration//GEN-END:variables

    
    //getters and setters
    
	public String getjTextField1Content() {
		return jTextField1.getText();
	}

	public void setjTextField1Content(String content) {
		this.jTextField1.setText(content);
	}    
    
}
