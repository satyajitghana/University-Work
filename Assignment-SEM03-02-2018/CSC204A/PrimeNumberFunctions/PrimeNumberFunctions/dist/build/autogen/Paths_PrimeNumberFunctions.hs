module Paths_PrimeNumberFunctions (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []
bindir, libdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/home/shadowleaf/.cabal/bin"
libdir     = "/home/shadowleaf/.cabal/lib/x86_64-linux-ghc-7.10.3/PrimeNumberFunctions-0.1.0.0-0CUBFa3rLGD0PLyXhVu5gJ"
datadir    = "/home/shadowleaf/.cabal/share/x86_64-linux-ghc-7.10.3/PrimeNumberFunctions-0.1.0.0"
libexecdir = "/home/shadowleaf/.cabal/libexec"
sysconfdir = "/home/shadowleaf/.cabal/etc"

getBinDir, getLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "PrimeNumberFunctions_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "PrimeNumberFunctions_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "PrimeNumberFunctions_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "PrimeNumberFunctions_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "PrimeNumberFunctions_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
