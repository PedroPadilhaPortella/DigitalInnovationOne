import { CampoGenerico } from "./CampoGenerico";

export interface ConfigParams {
    pagina?: number;
    limite?: number;
    pesquisa?: string;
    campo?: CampoGenerico;
}