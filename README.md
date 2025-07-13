![ServerReady Header](https://i.imgur.com/MzyOhS2.png)

[![Build Plugin](https://github.com/PlexPrison/ServerPersistence/actions/workflows/build.yml/badge.svg)](https://github.com/PlexPrison/ServerPersistence/actions/workflows/build.yml)

ServerReady is a plugin for infinitely running Mineplex Studio project instances until they are killed by external
factors. This permanently sets the project into `PRE_START` phase (meaning it will last forever, until killed).

The plugin will ensure all other plugins are done with their load process before marking the server as `PRE_START`. It
will fire the default Mineplex events to signify that everything is ready, so these are also suitable to listen to.

It's a very simple plugin, with no configuration.

## Installation

1. Head to the [latest release](https://github.com/PlexPrison/ServerReady/releases) of the plugin
2. Download the Jar file from the latest release
3. Plop `ServerReady-1.0.0.jar` into a folder within your Mineplex Project called `external-plugins`
4. Start your server, and profit.
