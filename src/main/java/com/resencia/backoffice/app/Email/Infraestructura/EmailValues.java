/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Email.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;

/**
 *
 * @author bunn3
 */
public class EmailValues {
    private String ticket;
    private String cred;

    public EmailValues() {
        this.ticket = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
"<head>\n" +
"	<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
"	<meta name=\"format-detection\" content=\"date=no\" />\n" +
"	<meta name=\"format-detection\" content=\"address=no\" />\n" +
"	<meta name=\"format-detection\" content=\"telephone=no\" />\n" +
"	<meta name=\"x-apple-disable-message-reformatting\" />\n" +
"    <!--[if !mso]><!-->\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=Noto+Sans:400,400i,700,700i\" rel=\"stylesheet\" />\n" +
"    <!--<![endif]-->\n" +
"	<title>Email Template</title>\n" +
"	<!--[if gte mso 9]>\n" +
"	<style type=\"text/css\" media=\"all\">\n" +
"		sup { font-size: 100% !important; }\n" +
"	</style>\n" +
"	<![endif]-->\n" +
"	\n" +
"\n" +
"	<style type=\"text/css\" media=\"screen\">\n" +
"		/* Linked Styles */\n" +
"		body { padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#f4f4f4; -webkit-text-size-adjust:none }\n" +
"		a { color:#66c7ff; text-decoration:none }\n" +
"		p { padding:0 !important; margin:0 !important } \n" +
"		img { -ms-interpolation-mode: bicubic; /* Allow smoother rendering of resized image in Internet Explorer */ }\n" +
"		.mcnPreviewText { display: none !important; }\n" +
"\n" +
"				\n" +
"		/* Mobile styles */\n" +
"		@media only screen and (max-device-width: 480px), only screen and (max-width: 480px) {\n" +
"			.mobile-shell { width: 100% !important; min-width: 100% !important; }\n" +
"			.bg { background-size: 100% auto !important; -webkit-background-size: 100% auto !important; }\n" +
"			\n" +
"			.text-header,\n" +
"			.m-center { text-align: center !important; }\n" +
"			\n" +
"			.center { margin: 0 auto !important; }\n" +
"			.container { padding: 20px 10px !important }\n" +
"			\n" +
"			.td { width: 100% !important; min-width: 100% !important; }\n" +
"\n" +
"			.m-br-15 { height: 15px !important; }\n" +
"			.p30-15 { padding: 30px 15px !important; }\n" +
"			.p40 { padding: 20px !important; }\n" +
"\n" +
"			.m-td,\n" +
"			.m-hide { display: none !important; width: 0 !important; height: 0 !important; font-size: 0 !important; line-height: 0 !important; min-height: 0 !important; }\n" +
"\n" +
"			.m-block { display: block !important; }\n" +
"\n" +
"			.fluid-img img { width: 100% !important; max-width: 100% !important; height: auto !important; }\n" +
"\n" +
"			.column,\n" +
"			.column-top,\n" +
"			.column-empty,\n" +
"			.column-empty2,\n" +
"			.column-dir-top { float: left !important; width: 100% !important; display: block !important; }\n" +
"			.column-empty { padding-bottom: 10px !important; }\n" +
"			.column-empty2 { padding-bottom: 20px !important; }\n" +
"			.content-spacing { width: 15px !important; }\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body class=\"body\" style=\"padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#f4f4f4; -webkit-text-size-adjust:none;\">\n" +
"	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#f4f4f4\">\n" +
"		<tr>\n" +
"			<td align=\"center\" valign=\"top\">\n" +
"				<table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">\n" +
"					<tr>\n" +
"						<td class=\"td container\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; margin:0; font-weight:normal; padding:55px 0px;\">\n" +
"							<!-- END Header -->\n" +
"\n" +
"							<!-- Intro -->\n" +
"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"padding-bottom: 20px;\">\n" +
"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"											<tr>\n" +
"												<td bgcolor=\"#6527FC\" valign=\"top\" height=\"366\" class=\"bg\" style=\"background-size:cover !important; -webkit-background-size:cover !important; background-repeat:none;\">\n" +
"													<div>\n" +
"														<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"															<tr>\n" +
"																<td class=\"content-spacing\" width=\"30\" height=\"366\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"></td>\n" +
"																<td style=\"padding: 30px 0px;\">\n" +
"																	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																		<tr>\n" +
"																			<td class=\"h1 center pb25\" style=\"color:#ffffff; font-family:'Noto Sans', Arial,sans-serif; font-size:40px; line-height:46px; text-align:center; padding-bottom:25px;\">Ticket resuelto</td>\n" +
"																		</tr>\n" +
"																		<tr>\n" +
"																			<td class=\"text-center\" style=\"color:#ffffff; font-family:'Noto Sans', Arial,sans-serif; font-size:16px; line-height:30px; text-align:center;\">Se ha resuelto su ticket de incidencia exitosamente.</td>\n" +
"																		</tr>\n" +
"																	</table>\n" +
"																</td>\n" +
"																<td class=\"content-spacing\" width=\"30\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"></td>\n" +
"															</tr>\n" +
"														</table>\n" +
"													</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"mp15\" style=\"padding: 20px 30px;\" bgcolor=\"#9A89C1\" align=\"center\">\n" +
"													<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"														<tr>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO WEB</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"															<th class=\"column\" width=\"50\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\"></th>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO MOVIL</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"\n" +
"															<th class=\"column\" width=\"50\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\"></th>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO A MEDIDA</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"							<!-- Footer -->\n" +
"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"								<tr>\n" +
"									<td class=\"p30-15\" style=\"padding: 50px 30px;\" bgcolor=\"#ffffff\">\n" +
"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"											<tr>\n" +
"												<td align=\"center\" style=\"padding-bottom: 30px;\">\n" +
"													<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"														<tr>\n" +
"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"https://resencia.com\" target=\"_blank\"><img src=\"https://resencia.com/wp-content/uploads/2020/09/cropped-logo.png\" width=\"45\" height=\"45\" border=\"0\" alt=\"\" /></a></td>\n" +
"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"https://www.instagram.com/resencia_web/\" target=\"_blank\"><img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/1200px-Instagram_logo_2016.svg.png\" width=\"45\" height=\"45\" border=\"0\" alt=\"\" /></a></td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"text-footer1 pb10\" style=\"color:#999999; font-family:'Noto Sans', Arial,sans-serif; font-size:16px; line-height:20px; text-align:center; padding-bottom:10px;\">Resencia.com Desarrollo WEB y Movil</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"text-footer2 pb30\" style=\"color:#999999; font-family:'Noto Sans', Arial,sans-serif; font-size:12px; line-height:26px; text-align:center; padding-bottom:30px;\">Granada</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"							<!-- END Footer -->" +
"						</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"			</td>\n" +
"		</tr>\n" +
"	</table>\n" +
"</body>\n" +
"</html>\n" +
"";
    }

    public EmailValues(CredencialesServicio credenciales) {
        this.cred = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
"<head>\n" +
"	<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
"	<meta name=\"format-detection\" content=\"date=no\" />\n" +
"	<meta name=\"format-detection\" content=\"address=no\" />\n" +
"	<meta name=\"format-detection\" content=\"telephone=no\" />\n" +
"	<meta name=\"x-apple-disable-message-reformatting\" />\n" +
"    <!--[if !mso]><!-->\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=Noto+Sans:400,400i,700,700i\" rel=\"stylesheet\" />\n" +
"    <!--<![endif]-->\n" +
"	<title>Email Template</title>\n" +
"\n" +
"	<style type=\"text/css\" media=\"screen\">\n" +
"		/* Linked Styles */\n" +
"		body { padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#f4f4f4; -webkit-text-size-adjust:none }\n" +
"		a { color:#66c7ff; text-decoration:none }\n" +
"		p { padding:0 !important; margin:0 !important } \n" +
"		img { -ms-interpolation-mode: bicubic; /* Allow smoother rendering of resized image in Internet Explorer */ }\n" +
"		.mcnPreviewText { display: none !important; }\n" +
"\n" +
"				\n" +
"		/* Mobile styles */\n" +
"		@media only screen and (max-device-width: 480px), only screen and (max-width: 480px) {\n" +
"			.mobile-shell { width: 100% !important; min-width: 100% !important; }\n" +
"			.bg { background-size: 100% auto !important; -webkit-background-size: 100% auto !important; }\n" +
"			\n" +
"			.text-header,\n" +
"			.m-center { text-align: center !important; }\n" +
"			\n" +
"			.center { margin: 0 auto !important; }\n" +
"			.container { padding: 20px 10px !important }\n" +
"			\n" +
"			.td { width: 100% !important; min-width: 100% !important; }\n" +
"\n" +
"			.m-br-15 { height: 15px !important; }\n" +
"			.p30-15 { padding: 30px 15px !important; }\n" +
"			.p40 { padding: 20px !important; }\n" +
"\n" +
"			.m-td,\n" +
"			.m-hide { display: none !important; width: 0 !important; height: 0 !important; font-size: 0 !important; line-height: 0 !important; min-height: 0 !important; }\n" +
"\n" +
"			.m-block { display: block !important; }\n" +
"\n" +
"			.fluid-img img { width: 100% !important; max-width: 100% !important; height: auto !important; }\n" +
"\n" +
"			.column,\n" +
"			.column-top,\n" +
"			.column-empty,\n" +
"			.column-empty2,\n" +
"			.column-dir-top { float: left !important; width: 100% !important; display: block !important; }\n" +
"			.column-empty { padding-bottom: 10px !important; }\n" +
"			.column-empty2 { padding-bottom: 20px !important; }\n" +
"			.content-spacing { width: 15px !important; }\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body class=\"body\" style=\"padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#f4f4f4; -webkit-text-size-adjust:none;\">\n" +
"	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#f4f4f4\">\n" +
"		<tr>\n" +
"			<td align=\"center\" valign=\"top\">\n" +
"				<table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">\n" +
"					<tr>\n" +
"						<td class=\"td container\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; margin:0; font-weight:normal; padding:55px 0px;\">\n" +
"\n" +
"							<!-- Intro -->\n" +
"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"padding-bottom: 20px;\">\n" +
"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"											<tr>\n" +
"												<td bgcolor=\"#6527FC\" valign=\"top\" height=\"366\" class=\"bg\" style=\"background-size:cover !important; -webkit-background-size:cover !important; background-repeat:none;\">\n" +
"													<div>\n" +
"														<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"															<tr>\n" +
"																<td class=\"content-spacing\" width=\"30\" height=\"366\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"></td>\n" +
"																<td style=\"padding: 30px 0px;\">\n" +
"																	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																		<tr>\n" +
"																			<td class=\"h1 center pb25\" style=\"color:#ffffff; font-family:'Noto Sans', Arial,sans-serif; font-size:40px; line-height:46px; text-align:center; padding-bottom:25px;\">Servicio operativo</td>\n" +
"																		</tr>\n" +
"																		<tr>\n" +
"																			<td class=\"text-center\" style=\"color:#ffffff; font-family:'Noto Sans', Arial,sans-serif; font-size:16px; line-height:30px; text-align:center;\">Se ha activado su servicio, ya puede disfrutar de el</td>\n" +
"																		</tr>\n" +
"																	</table>\n" +
"																</td>\n" +
"																<td class=\"content-spacing\" width=\"30\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"></td>\n" +
"															</tr>\n" +
"														</table>\n" +
"													</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"mp15\" style=\"padding: 20px 30px;\" bgcolor=\"#9A89C1\" align=\"center\">\n" +
"													<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"														<tr>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO WEB</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"															<th class=\"column\" width=\"50\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\"></th>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO MOVIL</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"\n" +
"															<th class=\"column\" width=\"50\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\"></th>\n" +
"															<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" +
"																<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"																	<tr>\n" +
"																		<td class=\"h5 white\" style=\"font-family:'Noto Sans', Arial,sans-serif; font-size:13px; line-height:22px; text-align:left; font-weight:bold; color:#ffffff;\">DESARROLLO A MEDIDA</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</th>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"\n" +
"							<!-- Article / Title + Copy + Button -->\n" +
"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"padding-bottom: 20px;\">\n" +
"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\n" +
"											<tr>\n" +
"												<td class=\"p30-15\" style=\"padding: 50px 30px;\">\n" +
"													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"														<tr>\n" +
"															<td class=\"h3 pb20\" style=\"color:#114490; font-family:'Noto Sans', Arial,sans-serif; font-size:24px; line-height:32px; text-align:left; padding-bottom:20px;\">Credenciales y datos de su servicio:</td>\n" +
"														</tr>\n" +
"														<tr>\n" +
"															<td class=\"text pb20\" style=\"color:#777777; font-family:'Noto Sans', Arial,sans-serif; font-size:14px; line-height:26px; text-align:left; padding-bottom:20px;\">\n" +
"																<p>Pagina web / IP : <b>" + credenciales.getIp()+ "</b></p>\n" +
"																<p>Username CMS : <b> " + credenciales.getUsernameCms()+ "</b></p>\n" +
"																<p>Password CMS : <b> " + credenciales.getPasswordCms()+ "</b></p>\n" +
"																<p>User FTP : <b>" + credenciales.getUserFtp()+ "</b></p>\n" +
"																<p>Password FTP : <b>" + credenciales.getPassFtp()+ "</b></p>\n" +
"																<p>Password SSH : <b>" + credenciales.getPassSsh()+ "</b></p>\n" +
"\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"							\n" +
"							<!-- Footer -->\n" +
"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"								<tr>\n" +
"									<td class=\"p30-15\" style=\"padding: 50px 30px;\" bgcolor=\"#ffffff\">\n" +
"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"											<tr>\n" +
"												<td align=\"center\" style=\"padding-bottom: 30px;\">\n" +
"													<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"														<tr>\n" +
"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"https://resencia.com\" target=\"_blank\"><img src=\"https://resencia.com/wp-content/uploads/2020/09/cropped-logo.png\" width=\"45\" height=\"45\" border=\"0\" alt=\"\" /></a></td>\n" +
"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"https://www.instagram.com/resencia_web/\" target=\"_blank\"><img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/1200px-Instagram_logo_2016.svg.png\" width=\"45\" height=\"45\" border=\"0\" alt=\"\" /></a></td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"text-footer1 pb10\" style=\"color:#999999; font-family:'Noto Sans', Arial,sans-serif; font-size:16px; line-height:20px; text-align:center; padding-bottom:10px;\">Resencia.com Desarrollo WEB y Movil</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td class=\"text-footer2 pb30\" style=\"color:#999999; font-family:'Noto Sans', Arial,sans-serif; font-size:12px; line-height:26px; text-align:center; padding-bottom:30px;\">Granada</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"							<!-- END Footer -->\n" +
"						</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"			</td>\n" +
"		</tr>\n" +
"	</table>\n" +
"</body>\n" +
"</html>";
    }
    
    

    public String getTicket() {
        return ticket;
    }

    public String getCred() {
        return cred;
    }
    
    

    
    
    
    
    
    
    
    
}
