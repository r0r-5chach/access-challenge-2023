<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="r0r5chach">

    <title>${title}</title>
    <link rel="stylesheet" href="/${style}.css" media = "screen">
    <link rel="stylesheet" href="/styles/mobile/${style}.css" media ="screen and (max-width:800px)">
</head>
<body id="clicked">
    <header>
        <img src="/images/logo.png"/>
    </header>
        <#include '${content}'>
    <footer>
        <a href="/">
            <img src="/images/logo.png"/>
            <p>&copy;nhs, Deny Solutions ${date}</p>
        </a>
    </footer>
</body>
</html>