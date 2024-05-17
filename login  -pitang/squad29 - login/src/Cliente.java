public class Cliente {
   
        private String nome;
        private String cnpj;
        private String apiKey;
        private String webhook;
        private int creditosPagina;
        private String telefone;
        private String endereco;

        public Cliente(String nome, String cnpj, String apiKey, String webhook, int creditosPagina, String telefone,
                String endereco) {
            this.nome = nome;
            this.cnpj = cnpj;
            this.apiKey = apiKey;
            this.webhook = webhook;
            this.creditosPagina = creditosPagina;
            this.telefone = telefone;
            this.endereco = endereco;
        }
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getCnpj() {
            return cnpj;
        }
        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }
        public String getApiKey() {
            return apiKey;
        }
        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
        public String getWebhook() {
            return webhook;
        }
        public void setWebhook(String webhook) {
            this.webhook = webhook;
        }
        public int getCreditosPagina() {
            return creditosPagina;
        }
        public void setCreditosPagina(int creditosPagina) {
            this.creditosPagina = creditosPagina;
        }
        public String getTelefone() {
            return telefone;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
        public String getEndereco() {
            return endereco;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    
        
        
}
