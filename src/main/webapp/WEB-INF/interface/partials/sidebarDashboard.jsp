<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a id = "Home" class="nav-link" aria-current="page" href="#">
                    <span data-feather="home"></span>
                    Home
                </a>
            </li>
            <li class="nav-item ">
                <a id = "Dashboard" class="nav-link" aria-current="page" href="/UniNotes_war_exploded/Utente/dashboard">
                    <span data-feather="bar-chart-2"></span>
                    Dashboard
                </a>
            </li>
            <li  class="nav-item">
                <a id = "Utenti" class="nav-link" href="/UniNotes_war_exploded/Utente/visualizzaUtenti">
                    <span data-feather="users"></span>
                    Utenti
                </a>
            </li>
            <li class="nav-item">
                <a id = "Materiale" class="nav-link" href="/UniNotes_war_exploded/Materiale/visualizzaTutti">
                    <span data-feather="file"></span>
                    Materiale
                </a>
            </li>
            <li class="nav-item">
                <a id = "Corsi" class="nav-link" href="/UniNotes_war_exploded/Corso/visualizzaTutti">
                    <span data-feather="book-open"></span>
                    Corsi
                </a>
            </li>
            <li class="nav-item">
                <a id = "Pagina personale" class="nav-link" href="/UniNotes_war_exploded/Utente/visualizzaPaginaPersonale">
                    <span data-feather="user"></span>
                    Pagina personale
                </a>
            </li>
        </ul>
    </div>
</nav>

<script>
    document.getElementById("${param.sezione}").classList.add("active");

</script>