grails.plugin.springsecurity.fii.rejectIfNoRule = true
grails.plugin.springsecurity.rejectPublicInvocations = false

grails.logging.jul.usebridge = true

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.active = true
grails.plugin.springsecurity.debug.useFilter = false
grails.plugin.springsecurity.sch.strategyName = 'MODE_INHERITABLETHREADLOCAL'
grails.plugin.springsecurity.ldap.context.server = 'ldap://10.1.28.30:389' //TODO
grails.plugin.springsecurity.ldap.auth.hideUserNotFoundExceptions = false
grails.plugin.springsecurity.ldap.authorities.retrieveDatabaseRoles = true
grails.plugin.springsecurity.ldap.authorities.groupSearchBase = 'ou=Groups,dc=lit,dc=inpe,dc=br'
grails.plugin.springsecurity.ldap.authorities.retrieveGroupRoles = true
grails.plugin.springsecurity.ldap.context.anonymousReadOnly = true
grails.plugin.springsecurity.ldap.search.base = 'dc=lit,dc=inpe,dc=br'
grails.plugin.springsecurity.ldap.search.filter = 'uid={0}'
grails.plugin.springsecurity.ldap.search.searchSubtree = true
grails.plugin.springsecurity.ldap.search.timeLimit = 1000

//grails.plugin.springsecurity.ldap.authorities.defaultRole = 'core.User'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'elit.comum.user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'core.UserRole'
grails.plugin.springsecurity.authority.className = 'core.Role'

//grails.plugin.springsecurity.ipRestrictions = []
grails.plugin.springsecurity.providerNames = ['ldapAuthProvider', 'anonymousAuthenticationProvider']

// Redirecionamentos
grails.plugin.springsecurity.auth.loginFormUrl = '/login'
grails.plugin.springsecurity.logout.afterLogoutUrl = '/login'
grails.plugin.springsecurity.failureHandler.defaultFailureUrl = '/login/?error=1'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/'
grails.plugin.springsecurity.successHandler.alwaysUseDefault = true

grails.plugin.springsecurity.logout.filterProcessesUrl = '/j_spring_security_logout'
grails.plugin.springsecurity.apf.filterProcessesUrl = '/j_spring_security_check'
grails.plugin.springsecurity.switchUser.switchUserUrl = '/j_spring_security_switch_user'
grails.plugin.springsecurity.switchUser.exitUserUrl = '/j_spring_security_exit_user'
grails.plugin.springsecurity.switchUser.usernameParameter = 'j_username'
grails.plugin.springsecurity.apf.usernameParameter = 'j_username'
grails.plugin.springsecurity.apf.passwordParameter = 'j_password'
grails.plugin.springsecurity.rememberMe.parameter = '_spring_security_remember_me'
//grails.plugin.springsecurity.sch.strategyName = 'MODE_INHERITABLETHREADLOCAL'

// Hierarquia de permissoes
grails.plugin.springsecurity.roleHierarchy = '''
	ROLE_ADMIN > ROLE_USER
'''

grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/**/*.zul',                                   access: ['permitAll']],
        [pattern: '/elit/comum/ramoDeAtividade.zul',             access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/recebimento.zul',       access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/listagem.zul',          access: ['ROLE_ADMIN']],
        [pattern: '/elit/comum/empresa.zul',                     access: ['ROLE_ADMIN']],
        [pattern: '/elit/comum/pessoafisica.zul',                access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/recebimento.zul',       access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/equipamentoRecebido.zul',           access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/compRecebimentoED.zul', access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/compRecebimentoNE.zul', access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/documento.zul',         access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/enviarEmails.zul',      access: ['ROLE_ADMIN']],
        [pattern: '/elit/pac/recebimento/movimentacao.zul',      access: ['ROLE_ADMIN']],
        [pattern: '/elit/core/permissao.zul',                    access: ['ROLE_ADMIN']],
        [pattern: '/elit/core/avisoManutencao.zul',              access: ['ROLE_ADMIN']],
        [pattern: '/elit/core/usuariosLogados.zul',              access: ['ROLE_ADMIN']],
        [pattern: '/elit/rh/relatorioAusencia.zul',              access: ['ROLE_ADMIN']],
        [pattern: '/', 	            	                         access: ['ROLE_ADMIN', 'ROLE_USER']],
        [pattern: '/elit/index.zul', 	            	         access: ['ROLE_ADMIN', 'ROLE_USER']],
        [pattern: '/login',                            	         access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern: '/manutencao',                            	 access: ['permitAll']],
//        [pattern: '/login/**',                                    access: ['ROLE_ADMIN']],
//        [pattern: '/logout/**',                                   access: ['permitAll']]
//        [pattern: '/**/j_spring_security_*',   			access: ['permitAll']],
//        [pattern: '/zkau\\?dtid=.*&cmd_0=rmDesktop&.*', access: ['permitAll']],
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/**/*.zul',        access: ['permitAll']],
        [pattern: '/index.gsp',       access: ['permitAll']],
        [pattern: '/assets/**',       access: ['permitAll']],
        [pattern: '/**/js/**',        access: ['permitAll']],
        [pattern: '/**/css/**',       access: ['permitAll']],
        [pattern: '/**/images/**',    access: ['permitAll']],
        [pattern: '/**/favicon.ico',  access: ['permitAll']],
        [pattern: '/login/**',        access: ['permitAll']],
        [pattern: '/**/areaCliente/**',        access: ['permitAll']],
        [pattern: '/Acesso/postAcesso',        access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/static/**',       filters: 'none'],
        [pattern: '/assets/**',       filters: 'none'],
        [pattern: '/**/js/**',        filters: 'none'],
        [pattern: '/**/css/**',       filters: 'none'],
        [pattern: '/**/images/**',    filters: 'none'],
        [pattern: '/**/favicon.ico',  filters: 'none'],
        [pattern: '/**/areaCliente/**',        filters: 'none'],
        [pattern: '/Acesso/postAcesso',        filters: 'none'],

        // Rotas Grailszk Plugin
        [pattern: '/zkau/**', 		  filters: 'none'],
        [pattern: '/zkcomet/**',	  filters: 'none'],
        [pattern: '/devZul/**',       filters: 'none'],
        [pattern: '/**',              filters: 'JOINED_FILTERS']
]

email {
    desenvolvimento = "maicon.silva@inpe.br"

    elit_dev = "elit@lit.inpe.br"
    elit = "elit.comit@inpe.br"
    pac = "pac@inpe.br"
    dsi = "dsi.comit@inpe.br"
    metrologia = "metrologia@inpe.br"
    cedoc = "cedoc.comit@inpe.br"
    host_inpe = "smtp1.inpe.br"
    port_inpe = 587
    props_inpe = props = ["mail.smtp.auth": "true", "mail.smtp.port":"465", "mail.smtp.ssl.enable":"true", "mail.smtp.ssl.trust":"*" ]

    elit_dev_desabilitar = false
    elit_desabilitar = false
    pac_desabilitar = false
    dsi_desabilitar = false
    metrologia_desabilitar = false
    cedoc_desabilitar = false
}

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://localhost:8080"

        grails.plugin.springsecurity.ldap.context.server = 'ldap://10.1.28.30:389' //OK

        /* Alterado por Michele */
//        path = "/home/raphael/workspace/elitfiles" //path para salvar os arquivos
        visualizadorPdf = "http://localhost:8888"


        grails{
            mail{

                elitDev{
                    disabled = email.elit_dev_desabilitar
                    host = "smtp.lit.inpe.br"
                    port = 465
                    username = "gdsi"
                    password = "@e20f40g80"
                    props = [
                            "mail.smtp.auth": "true",
                            "mail.smtp.port":"465",
                            "mail.smtp.ssl.enable":"true",
                            "mail.smtp.ssl.trust":"*"
                    ]
                    'default'{from = email.elit_dev}
                    overrideAddress = email.desenvolvimento
                }

                elit{
                    disabled = email.elit_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "elit.comit"
                    password = "EiTa3l*9"
                    props = email.props_inpe
                    'default'{from = email.elit}
                    overrideAddress = email.desenvolvimento
                }


                pac{
                    disabled = email.pac_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "pac"
                    password = "4tM#NJN2"
                    props = email.props_inpe
                    'default'{from = email.pac}
                    overrideAddress = email.desenvolvimento
                }

                dsi{
                    disabled = email.dsi_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "dsi.comit"
                    password = '$g20D40S60i'
                    props = email.props_inpe
                    'default'{from = email.dsi}
                    overrideAddress = email.desenvolvimento
                }


                metrologia{
                    disabled = email.metrologia_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "metrologia"
                    password = 'Afs2558@%%*'
                    props = email.props_inpe
                    'default'{from = email.metrologia}
                    overrideAddress = email.desenvolvimento
                }

                cedoc{
                    disabled = email.cedoc_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "cedoc.comit"
                    password = '72Oa#Y#v'
                    props = email.props_inpe
                    'default'{from = email.cedoc}
                    overrideAddress = email.desenvolvimento
                }

                relatorios_emc{}
                antenas{}
                eventos_visitas{}
                qualidade{}

            }
        }
    }


    production {
        grails.logging.jul.usebridge = false
        grails.plugin.springsecurity.ldap.context.server = 'ldap://localhost:389'
        grails.serverURL = "https://elit2.lit.inpe.br:8445"
        path = "/home/elitfiles"
        visualizadorPdf = "http://elit2.lit.inpe.br:8888"

        grails{
            mail{
                elitDev{
                    disabled = email.elit_dev_desabilitar
                    host = "smtp.lit.inpe.br"
                    port = 465
                    username = "gdsi"
                    password = "@e20f40g80"
                    props = [
                            "mail.smtp.auth": "true",
                            "mail.smtp.port":"465",
                            "mail.smtp.ssl.enable":"true",
                            "mail.smtp.ssl.trust":"*"
                    ]
                    'default'{from = email.elit_dev}
                }

                elit{
                    disabled = email.elit_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "elit.comit"
                    password = "EiTa3l*9"
                    props = email.props_inpe
                    'default'{from = email.elit}
                }


                pac{
                    disabled = email.pac_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "pac"
                    password = "4tM#NJN2"
                    props = email.props_inpe
                    'default'{from = email.pac}
                }

                dsi{
                    disabled = email.dsi_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "dsi.comit"
                    password = '$g20D40S60i'
                    props = email.props_inpe
                    'default'{from = email.dsi}
                }

                metrologia{
                    disabled = email.metrologia_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "metrologia"
                    password = 'Afs2558@%%*'
                    props = email.props_inpe
                    'default'{from = email.metrologia}
                }

                cedoc{
                    disabled = email.cedoc_desabilitar
                    host = email.host_inpe
                    port = email.port_inpe
                    username = "cedoc.comit"
                    password = '72Oa#Y#v'
                    props = email.props_inpe
                    'default'{from = email.cedoc}
                }
            }
        }



    }
    test {
        grails.serverURL = "http://localhost:8080/${appName}"
        //grails.plugin.springsecurity.active = false
        grails.plugin.springsecurity.ldap.context.server = 'ldap://10.1.28.30:389' //OK
    }
}

grails {
    mail {
//       disabled = true
        host = "smtp.lit.inpe.br"
        port = 465
        username = "gdsi" // fiz os testes com esta conta do gdsi. depois tem que alterar pra conta do elit
        password = "@e20f40g80" // alterar a senha
        props =["mail.smtp.port":"465", // porta do servidor SMTP
                "mail.smtp.ssl.enable":"true", // habilitar a configuracao de seguranca SSL
                "mail.smtp.ssl.trust":"*"] //este foi o comando que descobri que ignora o "certificado" que o junior tinha dito, ele "confia" no servidor... mas tem que ver se o parametro correto para colocar aqui � mesmo "*"
        //	  props = ["mail.smtp.starttls.enable":"true",
        //        	   "mail.smtp.port":"465"]
    }
}

auditLog {
    disabled = true
    verbose = true // verbosely log all changed values to db
    logIds = true // log db-ids of associated objects.
    // Note: if you change next 2 properties, you must update your database schema!
    tablename = 'log.auditoria' // table name for audit logs.
    largeValueColumnTypes = true // use large column db types for oldValue/newValue.
    TRUNCATE_LENGTH = 1000
    transactional = true
    cacheDisabled = true
    //replacementPatterns = ["local.example.xyz.":""] // replace with empty string.
    actorClosure = { request, session ->
        // SpringSecurity Core 1.1.2
        if (request.applicationContext.springSecurityService.principal instanceof java.lang.String){
            return request.applicationContext.springSecurityService.principal
        }else{
            return request.applicationContext.springSecurityService.principal?.username
        }
    }
}